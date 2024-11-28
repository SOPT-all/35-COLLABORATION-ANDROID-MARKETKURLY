package com.example.market_kurly.domain.model

data class ReviewUiData(
    val name: String,
    val content: String,
    val score: Float,
    val isAdd: Boolean,
    val image1: String? = null,
    val image2: String? = null,
    val image3: String? = null,
    val createdAt: String
)
