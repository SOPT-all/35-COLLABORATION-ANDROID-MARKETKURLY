package com.example.market_kurly.core.util.date

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toFormattedDate(): String {
    return try {
        val parsedDate = LocalDateTime.parse(this)
        parsedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    } catch (e: Exception) {
        this
    }
}