package com.example.market_kurly.domain.repository

import com.example.market_kurly.core.dummymodel.AlsoViewedData
import com.example.market_kurly.core.dummymodel.GoodsUiData

interface GoodsRepository {
    fun getDummyAlsoViewedList(): List<AlsoViewedData>
    fun getDummyGoodsDetail(): GoodsUiData
}