package com.codart.credits.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country(
    var code: String,
    @PrimaryKey
    var country_id: Int,
    var image: String,
    var name: String,
    var status: String
)