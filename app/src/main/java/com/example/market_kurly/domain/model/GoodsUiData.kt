package com.example.market_kurly.domain.model

data class GoodsUiData(
    val deliverType: String,
    val discount: Int,
    val discountedPrice: Int,
    val image: String,
    val membersDiscount: Int,
    val membersDiscountedPrice: Int,
    val name: String,
    val price: Int,
    val seller: String,
    val origin: String,
    val isInterest: Boolean,
    val infoData: GoodsInfoData,
)
data class GoodsInfoData(
    val allergy: String,
    val brix: String,
    val expiration: String,
    val notification: String,
    val packagingType: String,
    val sellingUnit: String,
    val weight: String,
)
