package io.billie.organisations.viewmodel

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.validation.constraints.NotBlank

data class AddressRequest(
    @field:NotBlank @JsonProperty("city_name") val cityName: String,
    @field:NotBlank val postcode: String,
    @field:NotBlank val address: String
)
