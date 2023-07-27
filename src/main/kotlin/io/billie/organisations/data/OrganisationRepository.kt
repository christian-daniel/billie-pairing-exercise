package io.billie.organisations.data

import io.billie.countries.model.CountryResponse
import io.billie.organisations.viewmodel.Address
import io.billie.organisations.viewmodel.AddressRequest
import io.billie.organisations.viewmodel.ContactDetails
import io.billie.organisations.viewmodel.ContactDetailsRequest
import io.billie.organisations.viewmodel.LegalEntityType
import io.billie.organisations.viewmodel.OrganisationRequest
import io.billie.organisations.viewmodel.OrganisationResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.Date
import java.sql.ResultSet
import java.util.UUID

@Repository
class OrganisationRepository {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Transactional(readOnly = true)
    fun findOrganisations(): List<OrganisationResponse> {
        return jdbcTemplate.query(organisationQuery(), organisationMapper())
    }

    @Transactional
    fun create(organisation: OrganisationRequest): UUID {
        validateOrganization(organisation)
        val contactDetailsId: UUID = createContactDetails(organisation.contactDetails)
        val addressId: UUID = createAddress(organisation.address)
        return createOrganisation(organisation, contactDetailsId, addressId)
    }

    private fun validateOrganization(organisation: OrganisationRequest) {
        if (!countryCodeValid(organisation)) throw UnableToFindCountry(organisation.countryCode)
        if (!cityNameValid(organisation)) throw UnableToFindCity(
            organisation.countryCode,
            organisation.address.cityName
        )
    }

    private fun countryCodeValid(organisation: OrganisationRequest): Boolean {
        val reply: Int? = jdbcTemplate.query(
            "select count(country_code) from organisations_schema.countries c WHERE c.country_code = ?",
            ResultSetExtractor {
                it.next()
                it.getInt(1)
            },
            organisation.countryCode
        )
        return (reply != null) && (reply > 0)
    }

    private fun cityNameValid(organisation: OrganisationRequest): Boolean {
        val reply: Int? = jdbcTemplate.query(
            "select count(*) from organisations_schema.cities c WHERE c.country_code = ? AND c.name = ?",
            ResultSetExtractor {
                it.next()
                it.getInt(1)
            },
            organisation.countryCode,
            organisation.address.cityName
        )
        return (reply != null) && (reply > 0)
    }

    private fun createOrganisation(org: OrganisationRequest, contactDetailsId: UUID, addressId: UUID): UUID {
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            { connection ->
                val ps = connection.prepareStatement(
                    "INSERT INTO organisations_schema.organisations (" +
                        "name, " +
                        "date_founded, " +
                        "country_code, " +
                        "vat_number, " +
                        "registration_number, " +
                        "legal_entity_type, " +
                        "contact_details_id, " +
                        "address_id" +
                        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    arrayOf("id")
                )
                ps.setString(1, org.name)
                ps.setDate(2, Date.valueOf(org.dateFounded))
                ps.setString(3, org.countryCode)
                ps.setString(4, org.VATNumber)
                ps.setString(5, org.registrationNumber)
                ps.setString(6, org.legalEntityType.toString())
                ps.setObject(7, contactDetailsId)
                ps.setObject(8, addressId)
                ps
            }, keyHolder
        )
        return keyHolder.getKeyAs(UUID::class.java)!!
    }

    private fun createContactDetails(contactDetails: ContactDetailsRequest): UUID {
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            { connection ->
                val ps = connection.prepareStatement(
                    "insert into organisations_schema.contact_details " +
                        "(" +
                        "phone_number, " +
                        "fax, " +
                        "email" +
                        ") values(?,?,?)",
                    arrayOf("id")
                )
                ps.setString(1, contactDetails.phoneNumber)
                ps.setString(2, contactDetails.fax)
                ps.setString(3, contactDetails.email)
                ps
            },
            keyHolder
        )
        return keyHolder.getKeyAs(UUID::class.java)!!
    }

    private fun createAddress(address: AddressRequest): UUID {
        val keyHolder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            { connection ->
                val ps = connection.prepareStatement(
                    "insert into organisations_schema.addresses " +
                        "(" +
                        "city_name, " +
                        "postcode, " +
                        "address" +
                        ") values(?,?,?)",
                    arrayOf("id")
                )
                ps.setString(1, address.cityName)
                ps.setString(2, address.postcode)
                ps.setString(3, address.address)
                ps
            },
            keyHolder
        )
        return keyHolder.getKeyAs(UUID::class.java)!!
    }

    private fun organisationQuery() = "select " +
        "o.id as id, " +
        "o.name as name, " +
        "o.date_founded as date_founded, " +
        "o.country_code as country_code, " +
        "c.id as country_id, " +
        "c.name as country_name, " +
        "o.VAT_number as VAT_number, " +
        "o.registration_number as registration_number," +
        "o.legal_entity_type as legal_entity_type," +
        "o.contact_details_id as contact_details_id, " +
        "cd.phone_number as phone_number, " +
        "cd.fax as fax, " +
        "cd.email as email, " +
        "a.id as address_id, " +
        "a.city_name as city_name, " +
        "a.postcode as postcode, " +
        "a.address as address " +
        "from " +
        "organisations_schema.organisations o " +
        "INNER JOIN organisations_schema.contact_details cd on o.contact_details_id::uuid = cd.id::uuid " +
        "INNER JOIN organisations_schema.countries c on o.country_code = c.country_code " +
        "LEFT JOIN organisations_schema.addresses a on o.address_id = a.id "

    private fun organisationMapper() = RowMapper<OrganisationResponse> { it: ResultSet, _: Int ->
        OrganisationResponse(
            it.getObject("id", UUID::class.java),
            it.getString("name"),
            Date(it.getDate("date_founded").time).toLocalDate(),
            mapCountry(it),
            it.getString("vat_number"),
            it.getString("registration_number"),
            LegalEntityType.valueOf(it.getString("legal_entity_type")),
            mapContactDetails(it),
            mapAddress(it),
        )
    }

    private fun mapContactDetails(it: ResultSet): ContactDetails {
        return ContactDetails(
            UUID.fromString(it.getString("contact_details_id")),
            it.getString("phone_number"),
            it.getString("fax"),
            it.getString("email")
        )
    }

    private fun mapAddress(it: ResultSet) = it.getString("address_id")?.let { id ->
        Address(
            UUID.fromString(id),
            it.getString("city_name"),
            it.getString("postcode"),
            it.getString("address")
        )
    }

    private fun mapCountry(it: ResultSet): CountryResponse {
        return CountryResponse(
            it.getObject("country_id", UUID::class.java),
            it.getString("country_name"),
            it.getString("country_code")
        )
    }
}
