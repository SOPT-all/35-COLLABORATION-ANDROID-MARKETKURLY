package com.example.market_kurly.feature.review.state

import com.example.market_kurly.core.dummymodel.GoodsUiData
import com.example.market_kurly.core.util.KeyStorage.ALL_TABS
import com.example.market_kurly.core.util.KeyStorage.GOODS_REVIEWS

data class ReviewState(
    val selectedTabIndex: Int = ALL_TABS.indexOf(GOODS_REVIEWS),
    val isFavorite: Boolean = false,
    val goodsDetails: GoodsUiData? = null,
)
