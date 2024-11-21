package com.example.market_kurly.domain.model

import com.example.market_kurly.data.dto.request.RequestSignUpDto

data class SignUpModel(
    val authenticationId: String,
    val password: String,
    val nickname: String
)

fun toSignUpModel(model: SignUpModel, phone: String? = null): RequestSignUpDto {
    return RequestSignUpDto(
        authenticationId = model.authenticationId,
        password = model.password,
        nickname = model.nickname,
        phone = phone
    )
}