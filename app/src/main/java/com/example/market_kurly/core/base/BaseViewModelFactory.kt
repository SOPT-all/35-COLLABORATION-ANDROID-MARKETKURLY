package com.example.market_kurly.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.market_kurly.domain.repository.ExampleRepository
import com.example.market_kurly.feature.ExampleViewModel

class BaseViewModelFactory(
    private val exampleRepository: ExampleRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExampleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return exampleRepository?.let { ExampleViewModel(it) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
