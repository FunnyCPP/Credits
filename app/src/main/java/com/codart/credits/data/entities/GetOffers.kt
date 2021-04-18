package com.codart.credits.data.entities

data class GetOffers(
        var error: List<String>,
        var success: Int,
        var data: MutableList<Offer>
)
