package com.example.market_kurly.feature.wishlist

import androidx.lifecycle.ViewModel
import com.example.market_kurly.data.dummy.WishListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WishListViewModel : ViewModel() {
    private val _wishListItems = MutableStateFlow<List<WishListItem>>(emptyList())
    val wishListItems: StateFlow<List<WishListItem>> = _wishListItems

    init {
        loadDummyData()
    }

    private fun loadDummyData() {
        _wishListItems.value = List(10) { index ->
            WishListItem(
                imageUrl = "https://via.placeholder.com/96*125",
                productName = "[프레지덩] 포션 버터 비가염 (10g X 20개입) $index",
                discountRate = "${10 + index}%",
                discountedPrice = "${9 - index},000원",
                originalPrice = "10,000원"
            )
        }
    }
}