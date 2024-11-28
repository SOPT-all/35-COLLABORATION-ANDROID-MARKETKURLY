package com.example.market_kurly.core.util

import okhttp3.internal.immutableListOf

object KeyStorage {
    // nav graph 요소 상수화
    const val HOME = "home"
    const val GOODS = "goods"
    const val REVIEW = "review"
    const val WISHLIST = "wishlist"

    // WishList CategoryMenu
    const val WISHLIST_CATEGORY_TOTAL = "전체"
    const val WISHLIST_CATEGORY_DAIRY_PRODUCT = "유제품"
    const val WISHLIST_CATEGORY_SIMPLE_PRODUCT = "간편식·밀키트·샐러드"
    const val WISHLIST_CATEGORY_FRUIT_NUTS_RICE = "과일·견과·쌀"
    const val WISHLIST_CATEGORY_SNACK = "간식·과자·떡"

    // Review Filter
    const val REVIEW_FILTER_RECENT = "최신순"
    const val REVIEW_FILTER_MOST_STARS = "별점높은순"
    const val REVIEW_FILTER_LEAST_STARS = "별점낮은순"

    // Review Star
    const val STAR_MAX_COUNT = 5

    // Response null 대체 문자열
    const val EMPTY_RESPONSE = "0"

    // GoodsDetail Tab 요소 상수화
    const val GOODS_DETAIL = "상품설명"
    const val GOODS_MORE_INFO = "상세정보"
    const val GOODS_REVIEWS = "후기"
    const val GOODS_INQUIRY = "문의"

    val ALL_TABS = immutableListOf(GOODS_DETAIL, GOODS_MORE_INFO, GOODS_REVIEWS, GOODS_INQUIRY)

    // GoodsDescription 상품 정보 Title 상수화
    const val ALLERGY = "알레르기정보"
    const val BRIX = "당도"
    const val EXPIRATION = "소비기한(또는 유통기한)정보"
    const val LIVESTOCK = "축산물 이력정보"
    const val NOTIFICATION = "안내사항"
    const val PACKAGING_TYPE = "포장타입"
    const val SELLING_UNIT = "판매단위"
    const val WEIGHT = "중량/용량"

    // Goods Membership Toggle Button Expand ItemId
    const val MEMBERSHIP_EXPAND = "expand_item"

    // 단위
    const val WON = "원"
    const val PERCENT = "%"
}
