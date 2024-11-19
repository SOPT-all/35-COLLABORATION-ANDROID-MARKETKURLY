package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.data.dto.request.RequestSignUpDto
import com.example.market_kurly.data.service.ExampleService
import com.example.market_kurly.domain.repository.ExampleRepository

class ExampleRepositoryImpl(
    private val exampleService: ExampleService
) : ExampleRepository {
    override suspend fun signUp(request: RequestSignUpDto): Result<String> = runCatching {
        val response = exampleService.signUp(request)
        response.message
    }
}