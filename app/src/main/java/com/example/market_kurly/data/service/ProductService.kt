package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseHomeDto
import retrofit2.http.GET

interface ProductService {
    @GET("/api/v1/products/main")
    suspend fun getHomeData(): BaseResponse<ResponseHomeDto>
}