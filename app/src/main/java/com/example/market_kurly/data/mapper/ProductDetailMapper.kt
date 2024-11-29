package com.example.market_kurly.data.mapper

import com.example.market_kurly.data.dto.response.ProductItem
import com.example.market_kurly.data.dto.response.ResponseHomeDto
import com.example.market_kurly.domain.model.HomeUiData
import com.example.market_kurly.domain.model.ProductUiData

fun ProductItem.toProductUiData() =  ProductUiData(
    id = this.id,
    name = this.name,
    image = this.image,
    price = this.price,
    discount = this.discount,
    discountPrice = this.discountPrice,
    reviewCount = this.reviewCount
)

fun ResponseHomeDto.toHomeUiData(): HomeUiData {
    return HomeUiData(
        mainTopProducts = mainTopProducts.map { it.toProductUiData() },
        mainMiddleProducts = mainMiddleProducts.map { it.toProductUiData() },
        mainBottomData = mainBottomData.map { it.toProductUiData() }
    )
}

