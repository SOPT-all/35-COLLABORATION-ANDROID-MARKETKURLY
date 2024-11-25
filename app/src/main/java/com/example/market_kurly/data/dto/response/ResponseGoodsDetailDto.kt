package com.example.market_kurly.data.dto.response

import kotlinx.serialization.Serializable


//TODO: 서버쌤들이 null 반환 고쳐주면 수정 필요
@Serializable
data class ResponseGoodsDetailDto(
    val name: String,
    val price: Int,
    val discount: Int,
    val discountedPrice: Int,
    val image: String,
    val membersDiscount: Int,
    val membersDiscountedPrice: Int,
    val deliveryType: String,
    val seller: String,
    val origin: String,
    val packagingType: String,
    val sellingUnit: String,
    val weight: String,
    val expiration: String? = null,
    val brix: Float? = null,
    val notification: String,
    val category: String,
    val allergy: String,
    val isInterest: Boolean,
)