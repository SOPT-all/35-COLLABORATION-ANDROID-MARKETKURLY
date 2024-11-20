package com.example.market_kurly.core.util.price

fun Int.calculateDiscountWithFloor(discountRate: Int): Int {
    val discountedPrice = this * (1 - discountRate / 100.0)
    return (discountedPrice / 10).toInt() * 10
}
