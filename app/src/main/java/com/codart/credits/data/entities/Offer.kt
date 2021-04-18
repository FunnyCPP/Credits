package com.codart.credits.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "offers")
data class Offer(
        //@Ignore var attribute_groups: List<AttributeGroup>,
        var background: String,
        //@Ignore var category: List<OfferCategory>,
        var country_id: String,
        var description: String,
        var href: String,
        var id: Int,
        var image: String,
        var model: String,
        var name: String,
        @PrimaryKey
    var product_id: Int,
        var slogan: String,
        var sort_order: Int,
        var status: String
)


data class AttributeGroup(
    var attribute: List<Attribute>,
    var attribute_group_id: String,
    var name: String
)

data class OfferCategory(
    var id: Int,
    var name: String
)


data class Attribute(
    var attribute_id: String,
    var name: String,
    var text: String
)
