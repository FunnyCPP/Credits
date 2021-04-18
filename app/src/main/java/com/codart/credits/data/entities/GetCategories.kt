package com.codart.credits.data.entities

data class GetCategories(
        var error: List<String>,
        var success: Int,
        var data: MutableList<Category>
)
