package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseReviewsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewService {

    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val PRODUCTS = "products"
        const val REVIEWS = "reviews"
    }

    @GET("/$API/$V1/$PRODUCTS/{productId}/$REVIEWS")
    suspend fun getProductReviews(
        @Path("productId") productId: Number
    ) : BaseResponse<ResponseReviewsDto>
}