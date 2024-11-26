package com.example.market_kurly.domain.repository

import com.example.market_kurly.domain.model.AlsoViewedData
import com.example.market_kurly.domain.model.GoodsUiData

interface GoodsRepository {
    fun getDummyAlsoViewedList(): List<AlsoViewedData>
    suspend fun getGoodsDetailById(productsId : Int, memberId : Int): Result<GoodsUiData?>
}
