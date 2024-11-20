package com.example.market_kurly.core.util

object KeyStorage {
    // nav graph 요소 상수화
    const val HOME = "home"
    const val GOODS = "goods"
    const val REVIEW = "review"
    const val WISHLIST = "wishlist"

    // GoodsDetail Tab 요소 상수화
    const val GOODS_DESCRIPTION = "상품설명"
    const val GOODS_DETAILS = "상세정보"
    const val GOODS_REVIEWS = "후기"
    const val GOODS_INQUIRY = "문의"

    val ALL_TABS = listOf(GOODS_DESCRIPTION, GOODS_DETAILS, GOODS_REVIEWS, GOODS_INQUIRY)
}