package com.example.market_kurly.feature.home

import com.example.market_kurly.R
import com.example.market_kurly.domain.model.ProductData


data class HomeState (
    val isSuccess: Boolean = false,
    val mainTopData: List<ProductData> = emptyList(),
    val mainMiddleData: List<ProductData> = emptyList(),
    val mainBottomData: List<ProductData> = emptyList(),
    val bannerList: List<String> = emptyList(),
)