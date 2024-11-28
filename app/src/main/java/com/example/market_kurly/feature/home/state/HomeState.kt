package com.example.market_kurly.feature.home.state

import com.example.market_kurly.domain.model.ProductUiData


data class HomeState (
    val isSuccess: Boolean = false,
    val mainTopData: List<ProductUiData> = emptyList(),
    val mainMiddleData: List<ProductUiData> = emptyList(),
    val mainBottomData: List<ProductUiData> = emptyList(),
    val bannerList: List<String> = emptyList(),
)