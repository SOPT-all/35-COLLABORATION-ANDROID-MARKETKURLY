package com.example.market_kurly.domain.repository

import com.example.market_kurly.domain.model.ReviewUiData

interface ReviewRepository {
    suspend fun getProductReviews(productId: Number): Result<List<ReviewUiData>>
}