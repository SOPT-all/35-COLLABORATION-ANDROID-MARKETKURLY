package com.example.market_kurly.data.dto.response

import com.example.market_kurly.domain.model.ProductData
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDto (
    val mainTopProducts: List<ProductData>,
    val mainMiddleProducts: List<ProductData>,
    val mainBottomData: List<ProductData>
)