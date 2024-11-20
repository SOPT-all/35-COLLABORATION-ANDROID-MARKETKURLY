package com.example.market_kurly.feature.goods.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.market_kurly.domain.repository.GoodsRepository

class GoodsViewModelFactory(
    private val goodsRepository: GoodsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoodsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GoodsViewModel(goodsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}