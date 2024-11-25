package com.example.market_kurly.data.service

import com.example.market_kurly.data.dto.request.RequestSignUpDto
import com.example.market_kurly.data.dto.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ExampleService {
    companion object {
        const val MEMBER = "member"
        const val JOIN = "join"
    }

    // 기본
    @POST("$MEMBER/$JOIN")
    suspend fun basicSignUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    // 코루틴
    @POST("$MEMBER/$JOIN")
    suspend fun signUp(
        @Body request: RequestSignUpDto,
    ): ResponseSignUpDto
}
