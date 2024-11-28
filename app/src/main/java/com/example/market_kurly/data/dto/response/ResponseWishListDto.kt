package com.example.market_kurly.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWishListDto(
    @SerialName("products")
    val products: List<WishListItem>
)

@Serializable
data class WishListItem(
    @SerialName("name")
    val name: String,
    @SerialName("image")
    val image: String,
    @SerialName("price")
    val price: Int,
    @SerialName("discount")
    val discount: Int,
    @SerialName("categoryScope")
    val categoryScope: String
)