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

    //GoodsDescription 상품 정보 Title 상수화
    const val ALLERGY = "알레르기정보"
    const val BRIX = "당도"
    const val EXPIRATION = "소비기한(또는 유통기한)정보"
    const val LIVESTOCK = "축산물 이력정보"
    const val NOTIFICATION = "안내사항"
    const val PACKAGING_TYPE = "포장타입"
    const val SELLING_UNIT = "판매단위"
    const val WEIGHT = "중량/용량"
}