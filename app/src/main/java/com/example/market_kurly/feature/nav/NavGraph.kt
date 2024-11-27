package com.example.market_kurly.feature.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market_kurly.core.util.KeyStorage.GOODS
import com.example.market_kurly.core.util.KeyStorage.HOME
import com.example.market_kurly.core.util.KeyStorage.REVIEW
import com.example.market_kurly.core.util.KeyStorage.WISHLIST
import com.example.market_kurly.feature.goods.GoodsScreen
import com.example.market_kurly.feature.goods.viewmodel.GoodsViewModel
import com.example.market_kurly.feature.home.HomeScreen
import com.example.market_kurly.feature.review.ReviewScreen
import com.example.market_kurly.feature.wishlist.WishListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    goodsViewModel: GoodsViewModel,
    ) {
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            HomeScreen(navController)
        }
        composable(GOODS) {
            GoodsScreen(navController, goodsViewModel)
        }
        composable(REVIEW) {
            ReviewScreen(navController)
        }
        composable(WISHLIST) {
            WishListScreen(navController)
        }
    }
}
