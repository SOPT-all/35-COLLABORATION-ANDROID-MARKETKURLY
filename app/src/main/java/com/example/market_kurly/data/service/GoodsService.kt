package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.request.RequestSignUpDto
import com.example.market_kurly.data.dto.response.ResponseGoodsDetailDto
import com.example.market_kurly.data.dto.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface GoodsService {
    companion object {
        const val PRODUCTS = "products"
    }

    @GET("$PRODUCTS/{productId}")
    suspend fun getGoodsDetailById(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<ResponseGoodsDetailDto>
}
