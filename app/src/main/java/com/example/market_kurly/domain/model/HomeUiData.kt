package com.example.market_kurly.domain.model

data class HomeUiData(
    val mainTopProducts: List<ProductUiData>,
    val mainMiddleProducts: List<ProductUiData>,
    val mainBottomData: List<ProductUiData>
)