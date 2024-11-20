package com.example.market_kurly.domain.handler

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MockFavoriteHandler : FavoriteHandler {
    private val _isFavorite = MutableStateFlow(false)
    override val isFavorite: StateFlow<Boolean> = _isFavorite

    override fun toggleFavorite() {
        _isFavorite.value = !_isFavorite.value
    }
}