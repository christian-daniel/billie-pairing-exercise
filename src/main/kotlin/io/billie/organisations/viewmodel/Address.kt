package io.billie.organisations.viewmodel

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Address(
    val id: UUID,
    @JsonProperty("city_name") val cityName: String,
    val postcode: String,
    val address: String
)
