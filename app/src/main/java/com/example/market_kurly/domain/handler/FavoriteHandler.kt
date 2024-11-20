package com.example.market_kurly.domain.handler

import kotlinx.coroutines.flow.StateFlow

interface FavoriteHandler {
    val isFavorite: StateFlow<Boolean>
    fun toggleFavorite()
}