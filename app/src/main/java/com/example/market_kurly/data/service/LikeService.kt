package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface LikeService {
    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val LIKES = "likes"
        const val PRODUCTS = "products"
    }

    @POST("$API/$V1/$LIKES/$PRODUCTS/{productId}")
    suspend fun postProductLike(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<String?>

    @DELETE("$API/$V1/$LIKES/$PRODUCTS/{productId}")
    suspend fun deleteProductLike(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<String?>
}