package com.example.market_kurly.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.domain.model.ProductData
import com.example.market_kurly.domain.repository.ProductsRepository
import com.example.market_kurly.feature.goods.state.GoodsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel (
    private val productsRepository: ProductsRepository,
) : ViewModel() {
    private var _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    init {
        getHomeProductsData()
    }

    private fun getHomeProductsData() {
        viewModelScope.launch {
            try {
                val response = productsRepository.getProducts()
                if (response.success) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            isSuccess = true,
                            mainTopData = response.data?.mainTopProducts ?: emptyList(),
                            mainMiddleData = response.data?.mainMiddleProducts ?: emptyList(),
                            mainBottomData = response.data?.mainBottomData ?: emptyList()
                        )
                    }
                } else {
                    _uiState.update { currentState ->
                        currentState.copy(isSuccess = false)
                    }
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(isSuccess = false)
                }
            }
        }
    }
}