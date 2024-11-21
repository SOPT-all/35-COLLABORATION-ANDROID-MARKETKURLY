package com.example.market_kurly.feature.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.feature.wishlist.component.WishListFilteringTab
import com.example.market_kurly.feature.wishlist.component.WishListProduct
import com.example.market_kurly.feature.wishlist.component.WishListTopBar
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.White

@Composable
fun WishListScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
        WishListTopBar(
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(20.dp))

        WishListFilteringTab(
            modifier = modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(10) {
                WishListProduct(
                    imageUrl = "https://via.placeholder.com/96*125",
                    productName = "[프레지덩] 포션 버터 비가염 (10g X 20개입) 줄이 넘어가나",
                    discountRate = "19%",
                    discountedPrice = "7,273원",
                    originalPrice = "8,980원"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishListPreview() {
    MARKETKURLYTheme {
        WishListScreen(modifier = Modifier, navController = rememberNavController())
    }
}