package com.example.market_kurly.domain.repository

interface LikeRepository {
    suspend fun postProductsLike(productsId : Int, memberId : Int): Result<String?>
    suspend fun deleteProductsLike(productsId : Int, memberId : Int): Result<String?>
}