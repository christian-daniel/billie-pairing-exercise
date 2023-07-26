package io.billie.functional.data

import java.text.SimpleDateFormat
import java.util.UUID

object Fixtures {

    fun orgRequestJsonNameBlank(): String {
        return "{\n" +
            "  \"name\": \"\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"GB\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonNoName(): String {
        return "{\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"GB\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonNoLegalEntityType(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"GB\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonNoContactDetails(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"GB\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\"\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJson(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"GB\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonCountryCodeBlank(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonNoCountryCode(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonCountryCodeIncorrect(): String {
        return "{\n" +
            "  \"name\": \"BBC\",\n" +
            "  \"date_founded\": \"18/10/1922\",\n" +
            "  \"country_code\": \"XX\",\n" +
            "  \"vat_number\": \"333289454\",\n" +
            "  \"registration_number\": \"3686147\",\n" +
            "  \"legal_entity_type\": \"NONPROFIT_ORGANIZATION\",\n" +
            "  \"contact_details\": {\n" +
            "    \"phone_number\": \"+443700100222\",\n" +
            "    \"fax\": \"\",\n" +
            "    \"email\": \"yourquestions@bbc.co.uk\"\n" +
            "  },\n" +
            "  \"address\": {\n" +
            "    \"city\": \"London\",\n" +
            "    \"postal_code\": \"W1A 1AA\",\n" +
            "    \"address\": \"Portland Place\"\n" +
            "  }\n" +
            "}"
    }

    fun orgRequestJsonNoCity() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "postal_code": "W1A 1AA",
    "address": "Portland Place"
  }
}
"""

    fun orgRequestJsonCityBlank() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "",
    "postal_code": "W1A 1AA",
    "address": "Portland Place"
  }
}
"""

    fun orgRequestJsonCityIncorrect() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "XXXXX",
    "postal_code": "W1A 1AA",
    "address": "Portland Place"
  }
}
"""

    fun orgRequestJsonNoPostalCode() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "London",
    "address": "Portland Place"
  }
}
"""

    fun orgRequestJsonPostalCodeBlank() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "London",
    "postal_code": "",
    "address": "Portland Place"
  }
}
"""

    fun orgRequestJsonNoAddress() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "London",
    "postal_code": "W1A 1AA",
  }
}
"""

    fun orgRequestJsonAddressBlank() = """
{
  "name": "BBC",
  "date_founded": "18/10/1922",
  "country_code": "GB",
  "vat_number": "333289454",
  "registration_number": "3686147",
  "legal_entity_type": "NONPROFIT_ORGANIZATION",
  "contact_details": {
    "phone_number": "+443700100222",
    "fax": "",
    "email": "yourquestions@bbc.co.uk"
  },
  "address": {
    "city": "London",
    "postal_code": "W1A 1AA",
    "address": ""
  }
}
"""

    fun bbcFixture(id: UUID): Map<String, Any> {
        val data = HashMap<String, Any>()
        data["id"] = id
        data["name"] = "BBC"
        data["date_founded"] = SimpleDateFormat("yyyy-MM-dd").parse("1922-10-18")
        data["country_code"] = "GB"
        data["vat_number"] = "333289454"
        data["registration_number"] = "3686147"
        data["legal_entity_type"] = "NONPROFIT_ORGANIZATION"
        return data
    }

    fun bbcContactFixture(id: UUID): Map<String, Any> {
        val data = HashMap<String, Any>()
        data["id"] = id
        data["phone_number"] = "+443700100222"
        data["fax"] = ""
        data["email"] = "yourquestions@bbc.co.uk"
        return data
    }

    fun bbcAddressFixture(id: UUID): Map<String, Any> {
        val data = HashMap<String, Any>()
        data["id"] = id
        data["city"] = "London"
        data["postal_code"] = "W1A 1AA"
        data["address"] = "Portland Place"
        return data
    }
}
