package com.codart.credits.data.entities

data class GetCountries(
    var error: List<String>,
    var success: Int,
    var data: MutableList<Country>
)