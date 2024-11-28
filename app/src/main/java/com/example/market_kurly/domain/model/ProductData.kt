package com.example.market_kurly.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductData (
    val id: Int,
    val name: String,
    val price: Int,
    val discount: Int,
    val image: String,
    val discountPrice: Int,
    val reviewCount: Int,
)