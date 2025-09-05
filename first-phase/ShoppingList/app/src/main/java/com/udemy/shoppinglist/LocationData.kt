package com.udemy.shoppinglist

data class LocationData(
    val latitude: Double,
    val longitude: Double,
)
data class NominatimResponse(
    val display_name: String,
    val address: NominatimAddress
)

data class NominatimAddress(
    val road: String?,
    val city: String?,
    val county: String?,
    val state: String?,
    val postcode: String?,
    val country: String?
)
