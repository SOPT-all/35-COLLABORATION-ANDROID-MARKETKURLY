package com.example.market_kurly.feature.goods.viewmodel

import androidx.lifecycle.ViewModel
import com.example.market_kurly.domain.handler.FavoriteHandler
import com.example.market_kurly.domain.repository.GoodsRepository
import com.example.market_kurly.feature.goods.state.GoodsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoodsViewModel(
    private val goodsRepository: GoodsRepository
) : ViewModel(), FavoriteHandler {

    private val _isFavorite = MutableStateFlow(false)
    override val isFavorite: StateFlow<Boolean> = _isFavorite

    private var _uiState = MutableStateFlow(GoodsState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeGoodsState()
    }

    private fun initializeGoodsState() = _uiState.update { currentState ->
        currentState.copy(
            alsoViewedList = goodsRepository.getDummyAlsoViewedList()
        )
    }

    fun updateSelectedTabIndex(index: Int) = _uiState.update { currentState ->
        currentState.copy(selectedTabIndex = index)
    }
    override fun toggleFavorite() {
        _uiState.update { currentState ->
            currentState.copy(isFavorite = !_uiState.value.isFavorite)
        }
        _isFavorite.value = !_isFavorite.value
        // TODO: API 연동 추가
    }
}