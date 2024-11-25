package com.example.market_kurly.feature.goods.viewmodel

import android.util.Log
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.R
import com.example.market_kurly.domain.model.GoodsInfoData
import com.example.market_kurly.core.util.KeyStorage.ALLERGY
import com.example.market_kurly.core.util.KeyStorage.BRIX
import com.example.market_kurly.core.util.KeyStorage.EXPIRATION
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

    @StringRes
    private val _snackbarMessage = MutableSharedFlow<Int>()

    @StringRes
    val snackbarMessage: SharedFlow<Int> = _snackbarMessage

    private val _navigateToWishlist = MutableSharedFlow<Unit>()
    val navigateToWishlist: SharedFlow<Unit> = _navigateToWishlist

    private var _uiState = MutableStateFlow(GoodsState())
    val uiState = _uiState.asStateFlow()

    fun getGoodsDetailData(productId: Int, memberId: Int) {
        viewModelScope.launch {
            val response = goodsRepository.getGoodsDetailById(productId, memberId)
                .onSuccess { goodsData ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            isSuccess = true,
                            alsoViewedList = goodsRepository.getDummyAlsoViewedList(),
                            goodsDetails = goodsData,
                            goodsInfoList = createInfoPairs(goodsData?.infoData),
                            isFavorite = goodsData?.isInterest ?: false,
                        )
                    }
                }
                .onFailure {
                    _uiState.update { currentState ->
                        currentState.copy(
                            isSuccess = false,
                            alsoViewedList = goodsRepository.getDummyAlsoViewedList(),
                        )
                    }

                }
            Log.d("HH", response.toString())
        }
    }

    //TODO: 서버쌤들이 null 반환 고쳐주면 수정 필요
    private fun createInfoPairs(info: GoodsInfoData?): List<Pair<String, String>> {
        info?.let {
            return listOf(
                PACKAGING_TYPE to info.packagingType,
                SELLING_UNIT to info.sellingUnit,
                WEIGHT to info.weight,
                ALLERGY to info.allergy,
                EXPIRATION to info.expiration.toString(),
                BRIX to info.brix.toString(),
                NOTIFICATION to info.notification,
            )
        }
        return emptyList()
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
