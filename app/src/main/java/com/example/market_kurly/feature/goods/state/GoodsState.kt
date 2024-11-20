package com.example.market_kurly.feature.goods.state

import com.example.market_kurly.core.dummymodel.AlsoViewedData
import com.example.market_kurly.core.dummymodel.GoodsDescriptionUiData
import com.example.market_kurly.core.util.KeyStorage.ALL_TABS
import com.example.market_kurly.core.util.KeyStorage.GOODS_DESCRIPTION

data class GoodsState(
    val selectedTabIndex: Int = ALL_TABS.indexOf(GOODS_DESCRIPTION),
    val isFavorite : Boolean = false,
    val alsoViewedList: List<AlsoViewedData> = emptyList(),
    val goodsDescriptions: GoodsDescriptionUiData? = null,
    val goodsInfoList: List<Pair<String, String>> = emptyList()
)
