package com.example.market_kurly.feature.review

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.R
import com.example.market_kurly.data.dummy.ReviewData
import com.example.market_kurly.feature.review.state.ReviewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReviewViewModel : ViewModel() {

    @StringRes private val _snackbarMessage = MutableSharedFlow<Int>()
    @StringRes val snackbarMessage: SharedFlow<Int> = _snackbarMessage

    private val _navigateToWishlist = MutableSharedFlow<Unit>()
    val navigateToWishlist: SharedFlow<Unit> = _navigateToWishlist

    private var _uiState = MutableStateFlow(ReviewState())
    val uiState = _uiState.asStateFlow()

    val reviews = listOf(
        ReviewData(
            userName = "신**",
            productName = "시나노골드 (금사과) 1.3kg (5~7입)",
            imageUrls = listOf(
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81"
            ),
            reviewText = "요즘 사과 품종별로 비교해보는 재미에 빠졌어요. 감홍의 맛을 가장 좋아하긴 하는데 맛 비교 자체가 너무 즐거워요.\n" +
                    "시나노골드는 처음 먹어보는데 황금사과라는 이름에 걸맞게 정말 금색이에요 ㅎㅎ\n" +
                    "일단은 그냥 온전히 껍질째 먹었어요. 확실히 연한 느낌이에요. 껍질도 과육도요.\n" +
                    "감홍이 깊은 단맛과 향이라면 이거는 싱그러운 단맛과 향이에요.",
            reviewDate = "2022.11.15",
            starCount = 4
        ),
        ReviewData(
            userName = "박**",
            productName = "부사 (사과) 2kg (6~8입)",
            imageUrls = listOf(
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
            ),
            reviewText = "사과가 정말 아삭아삭하고 맛있었어요. 껍질이 얇아서 그냥 먹기에도 부담 없고 단맛이 강해서 아이들도 좋아했어요.",
            reviewDate = "2022.11.10",
            starCount = 5
        ),
        ReviewData(
            userName = "김**",
            productName = "청송사과 (사과) 1.5kg (5~7입)",
            imageUrls = null,
            reviewText = "사과는 항상 청송사과가 최고죠! 신선도도 좋고 맛도 좋습니다. 추천합니다.",
            reviewDate = "2022.11.01",
            starCount = 3
        )
    )

    fun toggleFavorite() {
        _uiState.update { currentState ->
            currentState.copy(isFavorite = !_uiState.value.isFavorite)
        }
        viewModelScope.launch {
            if (_uiState.value.isFavorite) {
                _snackbarMessage.emit(R.string.goods_snackbar_message_favorite)
            }
        }
    }

    fun navigateToWishlist() {
        viewModelScope.launch {
            _navigateToWishlist.emit(Unit)
        }
    }
}