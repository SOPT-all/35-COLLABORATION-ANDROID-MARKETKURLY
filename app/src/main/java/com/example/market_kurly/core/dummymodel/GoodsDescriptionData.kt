package com.example.market_kurly.core.dummymodel

import kotlinx.serialization.SerialName

data class GoodsDescriptionData(
    val allergy: String,
    val brix: String,
    val category: String,
    @SerialName("deliver_type")
    val deliverType: String,
    val discount: Int,
    val expiration: String,
    val image: String,
    val livestock: String,
    @SerialName("members_discount")
    val membersDiscount: Int,
    val name: String,
    val notification: String,
    val origin: String,
    @SerialName("packaging_type")
    val packagingType: String,
    val price: Int,
    val seller: String,
    @SerialName("selling_unit")
    val sellingUnit: String,
    val view: Int,
    val weight: String,
    val isFavorite: Boolean
)
fun GoodsDescriptionData.asGoodsDescriptionUiData() = GoodsDescriptionUiData(
    deliverType = this.deliverType,
    discount = this.discount,
    image = this.image,
    membersDiscount = this.membersDiscount,
    name = this.name,
    price = this.price,
    seller = this.seller,
    origin = this.origin,
    isFavorite = this.isFavorite,
    infoData = GoodsDescriptionInfoData(
        allergy = this.allergy,
        brix = this.brix,
        expiration = this.expiration,
        livestock = this.livestock,
        notification = this.notification,
        packagingType = this.packagingType,
        sellingUnit = this.sellingUnit,
        weight = this.weight
    )
)