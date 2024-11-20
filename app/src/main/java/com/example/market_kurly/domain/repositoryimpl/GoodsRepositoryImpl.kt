package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.core.dummymodel.AlsoViewedItem
import com.example.market_kurly.domain.repository.GoodsRepository

class GoodsRepositoryImpl(

) : GoodsRepository {
    override fun getDummyAlsoViewedList(): List<AlsoViewedItem> =
        listOf(
            AlsoViewedItem("[KF365] 유명산지 고당도사과 1.5kg (5~6입)", 16, 19900),
            AlsoViewedItem("고랭지 햇사과 1.3kg (4~6입)", 13, 14900),
            AlsoViewedItem("감홍 사과 1.3kg (4~6입)", 25, 19900),
            AlsoViewedItem("세척 사과 1.4kg (7입)", 16, 14900)
        )
}