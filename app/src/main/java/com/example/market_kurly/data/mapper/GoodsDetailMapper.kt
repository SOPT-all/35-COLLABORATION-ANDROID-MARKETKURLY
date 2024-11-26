package com.example.market_kurly.data.mapper

import com.example.market_kurly.data.dto.response.ResponseGoodsDetailDto
import com.example.market_kurly.domain.model.GoodsInfoData
import com.example.market_kurly.domain.model.GoodsUiData
fun ResponseGoodsDetailDto.toGoodsUiData() = GoodsUiData(
    deliverType = this.deliveryType,
    discount = this.discount,
    image = this.image,
    membersDiscount = this.membersDiscount,
    discountedPrice = this.discountedPrice,
    membersDiscountedPrice = this.membersDiscountedPrice,
    name = this.name,
    price = this.price,
    seller = this.seller,
    origin = this.origin,
    isInterest = this.isInterest,
    infoData = GoodsInfoData(
        allergy = this.allergy,
        brix = this.brix,
        expiration = this.expiration,
        notification = this.notification,
        packagingType = this.packagingType,
        sellingUnit = this.sellingUnit,
        weight = this.weight,
    ),
)