package com.example.market_kurly.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDto(
    @SerialName("mainTopProducts")
    val mainTopProducts: List<ProductItem>,
    @SerialName("mainMiddleProducts")
    val mainMiddleProducts: List<ProductItem>,
    @SerialName("mainBottomData")
    val mainBottomData: List<ProductItem>
)

@Serializable
data class ProductItem (
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("discount")
    val discount: Int,
    @SerialName("image")
    val image: String,
    @SerialName("discountPrice")
    val discountPrice: Int,
    @SerialName("reviewCount")
    val reviewCount: Int,
)