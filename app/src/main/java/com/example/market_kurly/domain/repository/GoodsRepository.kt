package com.example.market_kurly.domain.repository

import com.example.market_kurly.core.dummymodel.AlsoViewedData

interface GoodsRepository {
    fun getDummyAlsoViewedList(): List<AlsoViewedData>
}