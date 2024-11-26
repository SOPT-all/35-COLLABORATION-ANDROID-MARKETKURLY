package com.example.market_kurly.domain.model

//TODO: 서버쌤들이 null 반환 고쳐주면 수정 필요
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
    val brix: Float?,
    val expiration: String?,
    val notification: String,
    val packagingType: String,
    val sellingUnit: String,
    val weight: String,
)
