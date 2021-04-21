package com.codart.credits.data.entities

data class GetOffersDetail(
        var error: List<String>,
        var success: Int,
        var data: Offer
)
