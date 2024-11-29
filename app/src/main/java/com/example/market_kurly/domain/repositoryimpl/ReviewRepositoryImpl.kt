package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.data.mapper.toReviewUiDataList
import com.example.market_kurly.data.service.ReviewService
import com.example.market_kurly.domain.model.ReviewUiData
import com.example.market_kurly.domain.repository.ReviewRepository

class ReviewRepositoryImpl(
    private val reviewService: ReviewService
) : ReviewRepository {
    override suspend fun getProductReviews(productId: Number): Result<List<ReviewUiData>> =
        runCatching {
            val response = reviewService.getProductReviews(productId)
            response.data?.toReviewUiDataList() ?: emptyList()
        }
}