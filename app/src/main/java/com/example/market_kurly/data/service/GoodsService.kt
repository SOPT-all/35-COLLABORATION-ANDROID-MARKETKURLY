package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseGoodsDetailDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GoodsService {
    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val PRODUCTS = "products"
    }

    @GET("$API/$V1/$PRODUCTS/{productId}")
    suspend fun getGoodsDetailById(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<ResponseGoodsDetailDto>
}
