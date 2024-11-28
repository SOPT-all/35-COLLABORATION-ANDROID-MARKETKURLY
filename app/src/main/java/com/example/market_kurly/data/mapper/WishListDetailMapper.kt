package com.example.market_kurly.data.mapper

import com.example.market_kurly.data.dto.response.ResponseWishListDto
import com.example.market_kurly.data.dto.response.WishListItem
import com.example.market_kurly.domain.model.WishListUiData

fun ResponseWishListDto.toWishListDataList(): List<WishListUiData> {
    return products.map { wishListItem ->
        wishListItem.toWishListUiData()
    }
}

fun WishListItem.toWishListUiData() = WishListUiData(
    name = this.name,
    image = this.image,
    price = this.price,
    discount = this.discount,
    categoryScope = this.categoryScope
)