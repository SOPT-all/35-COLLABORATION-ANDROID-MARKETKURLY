package com.example.market_kurly.feature.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.market_kurly.feature.goods.GoodsScreen
import com.example.market_kurly.feature.home.HomeScreen
import com.example.market_kurly.feature.review.ReviewScreen
import com.example.market_kurly.feature.wishlist.WishListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("goods") {
            GoodsScreen(navController)
        }
        composable("review") {
            ReviewScreen(navController)
        }
        composable("wishlist") {
            WishListScreen(navController)
        }
    }
}