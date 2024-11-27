package com.example.market_kurly.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.market_kurly.domain.repository.ExampleRepository
import com.example.market_kurly.domain.repository.GoodsRepository
import com.example.market_kurly.domain.repository.LikeRepository
import com.example.market_kurly.domain.repository.ProductsRepository
import com.example.market_kurly.feature.ExampleViewModel
import com.example.market_kurly.feature.goods.viewmodel.GoodsViewModel
import com.example.market_kurly.feature.home.HomeViewModel

class BaseViewModelFactory(
    private val exampleRepository: ExampleRepository? = null,
    private val goodsRepository: GoodsRepository? = null,
    private val likeRepository: LikeRepository? = null,
    private val productsRepository: ProductsRepository? = null
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ExampleViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                exampleRepository?.let { ExampleViewModel(it) } as T
            }

            modelClass.isAssignableFrom(GoodsViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                goodsRepository?.let {
                    likeRepository?.let {
                        GoodsViewModel(
                            goodsRepository = goodsRepository,
                            likeRepository = likeRepository
                        )
                    }
                } as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                productsRepository?.let {
                    HomeViewModel(
                        productsRepository = productsRepository
                    )
                } as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
