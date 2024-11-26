package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.base.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface LikeService {
    companion object {
        const val LIKES = "likes"
        const val PRODUCTS = "products"
    }

    @POST("$LIKES/$PRODUCTS/{productId}")
    suspend fun like(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<String?>

    @DELETE("$LIKES/$PRODUCTS/{productId}")
    suspend fun unLike(
        @Path("productId") productsId : Int,
        @Header("memberId") memberId : Int,
    ): BaseResponse<String?>
}