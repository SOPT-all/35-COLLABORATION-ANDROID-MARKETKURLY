package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseHomeDto
import retrofit2.http.GET

interface ProductService {
    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val MAIN = "main"
        const val PRODUCTS = "products"
    }

    @GET("/$API/$V1/$PRODUCTS/$MAIN")
    suspend fun getHomeData(): BaseResponse<ResponseHomeDto>
}