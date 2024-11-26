package com.example.market_kurly.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.market_kurly.domain.repository.ExampleRepository
import com.example.market_kurly.domain.repository.GoodsRepository
import com.example.market_kurly.feature.ExampleViewModel
import com.example.market_kurly.feature.goods.viewmodel.GoodsViewModel

class BaseViewModelFactory(
    private val exampleRepository: ExampleRepository? = null,
    private val goodsRepository: GoodsRepository? = null,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ExampleViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                exampleRepository?.let { ExampleViewModel(it) } as T
            }
            modelClass.isAssignableFrom(GoodsViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                goodsRepository?.let { GoodsViewModel(it) } as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
