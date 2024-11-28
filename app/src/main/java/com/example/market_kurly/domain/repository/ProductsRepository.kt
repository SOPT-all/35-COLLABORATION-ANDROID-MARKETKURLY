package com.example.market_kurly.domain.repository

import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseHomeDto

interface ProductsRepository {
    suspend fun getProducts(): BaseResponse<ResponseHomeDto>
}