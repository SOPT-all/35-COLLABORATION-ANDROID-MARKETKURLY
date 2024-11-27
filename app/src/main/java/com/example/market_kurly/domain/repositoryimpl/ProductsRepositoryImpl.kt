package com.example.market_kurly.domain.repositoryimpl

import android.util.Log
import com.example.market_kurly.data.dto.base.BaseResponse
import com.example.market_kurly.data.dto.response.ResponseHomeDto
import com.example.market_kurly.data.service.ProductService
import com.example.market_kurly.domain.repository.ProductsRepository

class ProductsRepositoryImpl(private val productService: ProductService) : ProductsRepository {
    override suspend fun getProducts(): BaseResponse<ResponseHomeDto> {
        return try {
            val response = productService.getHomeData()
            if (response.data != null) {
                response
            } else {
                throw IllegalStateException("Received null data from API")
            }
        } catch (e: Exception) {
            BaseResponse(
                success = false,
                message = "Error fetching data: ${e.localizedMessage}",
                data = null
            )
        }
    }
}