package com.example.market_kurly.feature.goods.state

import com.example.market_kurly.core.dummymodel.AlsoViewedData
import com.example.market_kurly.core.dummymodel.GoodsUiData
import com.example.market_kurly.core.util.KeyStorage.ALL_TABS
import com.example.market_kurly.core.util.KeyStorage.GOODS_DETAIL

data class GoodsState(
    val selectedTabIndex: Int = ALL_TABS.indexOf(GOODS_DETAIL),
    val isFavorite: Boolean = false,
    val alsoViewedList: List<AlsoViewedData> = emptyList(),
    val goodsDetails: GoodsUiData? = null,
    val goodsInfoList: List<Pair<String, String>> = emptyList(),
)
