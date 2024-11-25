package com.example.market_kurly.domain.repository

import com.example.market_kurly.data.dto.request.RequestSignUpDto

interface ExampleRepository {
    suspend fun signUp(request: RequestSignUpDto): Result<String>
}
