package com.example.market_kurly.domain.repository

import com.example.market_kurly.domain.model.SignUpModel

interface ExampleRepository {
    suspend fun signUp(request: SignUpModel): Result<String>
}
