package com.example.market_kurly.feature.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.core.base.BaseViewModelFactory
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
    val viewModel: WishListViewModel = viewModel(factory = BaseViewModelFactory())
    val wishList by viewModel.wishListItems.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getWishListData(memberId = 1)
    }

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
            modifier = modifier.fillMaxWidth(),
            onClick = {}
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(wishList) { wishListItem ->
                WishListProduct(
                    name = wishListItem.name,
                    image = wishListItem.image,
                    price = wishListItem.price,
                    discount = wishListItem.discount,
                    categoryScope = wishListItem.categoryScope
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