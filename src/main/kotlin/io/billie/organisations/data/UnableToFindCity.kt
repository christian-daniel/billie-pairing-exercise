package io.billie.organisations.data

data class UnableToFindCity(
    val countryCode: String,
    val cityName: String,
) : RuntimeException()
