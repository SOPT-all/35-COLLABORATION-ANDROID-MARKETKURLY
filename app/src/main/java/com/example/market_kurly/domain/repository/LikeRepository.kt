package com.example.market_kurly.domain.repository

interface LikeRepository {
    suspend fun like(productsId : Int, memberId : Int): Result<String?>
    suspend fun unLike(productsId : Int, memberId : Int): Result<String?>
}