package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.data.dto.ResponseExampleDto
import com.example.market_kurly.data.service.ExampleService
import com.example.market_kurly.domain.repository.ExampleRepository

class ExampleRepositoryImpl(
    private val exampleService: ExampleService
) : ExampleRepository {
    override suspend fun postExample(requestExample: Unit): ResponseExampleDto {
        return exampleService.postExample2(requestExample)
    }
}