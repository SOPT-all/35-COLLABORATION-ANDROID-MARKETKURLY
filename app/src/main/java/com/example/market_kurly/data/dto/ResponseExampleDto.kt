package com.example.market_kurly.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseExampleDto(
    @SerialName("test")
    val test: String
)
