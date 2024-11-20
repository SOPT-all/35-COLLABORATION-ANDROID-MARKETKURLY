package com.example.market_kurly.domain.repository

import com.example.market_kurly.core.dummymodel.AlsoViewedItem

interface GoodsRepository {
    fun getDummyAlsoViewedList(): List<AlsoViewedItem>
}