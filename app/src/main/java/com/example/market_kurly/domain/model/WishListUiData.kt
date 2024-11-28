package com.example.market_kurly.domain.model

data class WishListUiData(
    val name: String,
    val image: String,
    val price: Int,
    val discount: Int,
    val categoryScope: String
)
