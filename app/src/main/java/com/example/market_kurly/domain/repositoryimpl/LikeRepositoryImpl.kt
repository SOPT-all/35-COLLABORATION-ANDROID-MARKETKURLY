package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.data.service.LikeService
import com.example.market_kurly.domain.repository.LikeRepository

class LikeRepositoryImpl(
    private val likeService: LikeService,
) : LikeRepository {

    override suspend fun like(productsId: Int, memberId: Int): Result<String?> = runCatching {
        val response = likeService.like(productsId, memberId)
        response.data
    }

    override suspend fun unLike(productsId: Int, memberId: Int): Result<String?> = runCatching {
        val response = likeService.unLike(productsId, memberId)
        response.data
    }
}
