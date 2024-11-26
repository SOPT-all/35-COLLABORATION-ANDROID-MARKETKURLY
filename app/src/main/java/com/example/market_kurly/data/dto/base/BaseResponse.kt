package com.example.market_kurly.data.dto.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("status")
    val status: Int? = null,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T? = null,
)

@Serializable
data class BaseError(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
)
