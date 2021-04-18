package com.codart.credits.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
        @PrimaryKey
    var category_id: Int,
    var count_offer: String,
    var image: String,
    var name: String
)