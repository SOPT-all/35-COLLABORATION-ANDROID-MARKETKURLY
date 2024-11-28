package com.example.market_kurly.domain.model

data class ProductUiData (
    val id: Int,
    val name: String,
    val price: Int,
    val discount: Int,
    val image: String,
    val discountPrice: Int,
    val reviewCount: Int,
)

