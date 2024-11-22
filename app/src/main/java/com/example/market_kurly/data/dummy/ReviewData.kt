package com.example.market_kurly.data.dummy

data class ReviewData(
    val userName: String,
    val productName: String,
    val imageUrls: List<String>?,
    val reviewText: String,
    val reviewDate: String,
    val starCount: Int
)
