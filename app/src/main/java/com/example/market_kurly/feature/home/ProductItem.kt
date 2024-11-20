package com.example.market_kurly.feature.home


data class ProductItem (
    val title: String,
    val imageUrl: String,
    val discountBeforePrice: Int,
    val discountPercent: Int,
    val discountAfterPrice: Int,
    val reviewCount: Int = 0,
)