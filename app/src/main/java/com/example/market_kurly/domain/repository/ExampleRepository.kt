package com.example.market_kurly.domain.repository

import com.example.market_kurly.data.dto.ResponseExampleDto

interface ExampleRepository {
    suspend fun postExample(requestExample: Unit): ResponseExampleDto
}