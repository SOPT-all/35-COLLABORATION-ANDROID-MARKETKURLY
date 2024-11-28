package com.example.market_kurly.data.mapper

import com.example.market_kurly.data.dto.response.ResponseReviewsDto
import com.example.market_kurly.data.dto.response.ReviewItem
import com.example.market_kurly.domain.model.ReviewUiData

fun ResponseReviewsDto.toReviewUiDataList(): List<ReviewUiData> {
    return reviews.map { reviewItem ->
        reviewItem.toReviewUiData()
    }
}

fun ReviewItem.toReviewUiData() = ReviewUiData(
    userName = this.userName,
    content = this.content,
    score = this.score,
    isAdd = this.isAdd,
    image1 = this.image1,
    image2 = this.image2,
    image3 = this.image3,
    createdAt = this.createdAt
)