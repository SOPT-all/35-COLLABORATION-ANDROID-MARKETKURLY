package com.example.market_kurly.feature.goods.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.R
import com.example.market_kurly.core.dummymodel.GoodsInfoData
import com.example.market_kurly.core.util.KeyStorage.ALLERGY
import com.example.market_kurly.core.util.KeyStorage.BRIX
import com.example.market_kurly.core.util.KeyStorage.EXPIRATION
import com.example.market_kurly.core.util.KeyStorage.LIVESTOCK
import com.example.market_kurly.core.util.KeyStorage.NOTIFICATION
import com.example.market_kurly.core.util.KeyStorage.PACKAGING_TYPE
import com.example.market_kurly.core.util.KeyStorage.SELLING_UNIT
import com.example.market_kurly.core.util.KeyStorage.WEIGHT
import com.example.market_kurly.domain.repository.GoodsRepository
import com.example.market_kurly.feature.goods.state.GoodsState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GoodsViewModel(
    private val goodsRepository: GoodsRepository,
) : ViewModel() {

    @StringRes private val _snackbarMessage = MutableSharedFlow<Int>()

    @StringRes val snackbarMessage: SharedFlow<Int> = _snackbarMessage

    private val _navigateToWishlist = MutableSharedFlow<Unit>()
    val navigateToWishlist: SharedFlow<Unit> = _navigateToWishlist

    private var _uiState = MutableStateFlow(GoodsState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeGoodsState()
    }

    private fun initializeGoodsState() {
        _uiState.update { currentState ->
            val goodsDetailData = goodsRepository.getDummyGoodsDetail()
            currentState.copy(
                alsoViewedList = goodsRepository.getDummyAlsoViewedList(),
                goodsDetails = goodsDetailData,
                goodsInfoList = createInfoPairs(goodsDetailData.infoData),
                isFavorite = goodsDetailData.isFavorite,
            )
        }
    }
    private fun createInfoPairs(info: GoodsInfoData): List<Pair<String, String>> {
        return listOf(
            PACKAGING_TYPE to info.packagingType,
            SELLING_UNIT to info.sellingUnit,
            WEIGHT to info.weight,
            ALLERGY to info.allergy,
            EXPIRATION to info.expiration,
            BRIX to info.brix,
            NOTIFICATION to info.notification,
            LIVESTOCK to info.livestock,
        )
    }

    fun toggleFavorite() {
        _uiState.update { currentState ->
            currentState.copy(isFavorite = !_uiState.value.isFavorite)
        }
        viewModelScope.launch {
            if (_uiState.value.isFavorite) {
                _snackbarMessage.emit(R.string.goods_snackbar_message_favorite)
            }
        }
        // TODO: API 연동 추가
    }

    fun navigateToWishlist() {
        viewModelScope.launch {
            _navigateToWishlist.emit(Unit)
        }
    }
}
