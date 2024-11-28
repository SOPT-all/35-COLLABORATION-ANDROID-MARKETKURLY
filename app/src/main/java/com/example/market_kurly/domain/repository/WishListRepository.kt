package com.example.market_kurly.domain.repository

import com.example.market_kurly.domain.model.WishListUiData

interface WishListRepository {
    suspend fun getWishList(memberId: Number): Result<List<WishListUiData>>
}