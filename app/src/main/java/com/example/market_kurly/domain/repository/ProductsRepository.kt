package com.example.market_kurly.domain.repository

import com.example.market_kurly.domain.model.HomeUiData

interface ProductsRepository {
    suspend fun getProducts(): Result<HomeUiData>
}