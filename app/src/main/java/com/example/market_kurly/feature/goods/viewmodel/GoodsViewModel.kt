package com.example.market_kurly.feature.goods.viewmodel

import androidx.lifecycle.ViewModel
import com.example.market_kurly.core.dummymodel.GoodsDescriptionInfoData
import com.example.market_kurly.core.util.KeyStorage.ALLERGY
import com.example.market_kurly.core.util.KeyStorage.BRIX
import com.example.market_kurly.core.util.KeyStorage.EXPIRATION
import com.example.market_kurly.core.util.KeyStorage.LIVESTOCK
import com.example.market_kurly.core.util.KeyStorage.NOTIFICATION
import com.example.market_kurly.core.util.KeyStorage.PACKAGING_TYPE
import com.example.market_kurly.core.util.KeyStorage.SELLING_UNIT
import com.example.market_kurly.core.util.KeyStorage.WEIGHT
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

    //TODO: isFavorite 찜하기 여부 어떻게 관리할 지 (현재 중복 됨)
    private val _isFavorite = MutableStateFlow(false)
    override val isFavorite: StateFlow<Boolean> = _isFavorite //BottomBar에 쓰이는 찜하기 변수

    private var _uiState = MutableStateFlow(GoodsState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeGoodsState()
    }

    private fun initializeGoodsState() {
        _uiState.update { currentState ->
            val goodsDescriptionData = goodsRepository.getDummyGoodsDescription()
            currentState.copy(
                alsoViewedList = goodsRepository.getDummyAlsoViewedList(),
                goodsDescriptions = goodsDescriptionData,
                goodsInfoList = createDescriptionPairs(goodsDescriptionData.infoData),
                isFavorite = goodsDescriptionData.isFavorite
            )
        }
        _isFavorite.value = _uiState.value.isFavorite
    }
    private fun createDescriptionPairs(info: GoodsDescriptionInfoData): List<Pair<String, String>> {
        return listOf(
            ALLERGY to info.allergy,
            BRIX to info.brix,
            EXPIRATION to info.expiration,
            LIVESTOCK to info.livestock,
            NOTIFICATION to info.notification,
            PACKAGING_TYPE to info.packagingType,
            SELLING_UNIT to info.sellingUnit,
            WEIGHT to info.weight
        )
    }

    override fun toggleFavorite() {
        _uiState.update { currentState ->
            currentState.copy(isFavorite = !_uiState.value.isFavorite)
        }
        _isFavorite.value = !_isFavorite.value
        // TODO: API 연동 추가
    }
}