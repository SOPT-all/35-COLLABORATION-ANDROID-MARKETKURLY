package com.example.market_kurly.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.market_kurly.feature.home.component.HomeBannerRow
import com.example.market_kurly.feature.home.component.HomeTopBar

private val bannerList = listOf(
    "https://velog.velcdn.com/images/roel_dev/post/c6270de0-ab33-4374-bacd-eaa541ecc521/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/3d117f6f-9d9e-4899-bcba-cb137ac19c39/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/c6270de0-ab33-4374-bacd-eaa541ecc521/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/3d117f6f-9d9e-4899-bcba-cb137ac19c39/image.png",
)
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        HomeTopBar()
        HomeBannerRow(bannerList)

    }
}

//        Text(
//            text = stringResource(R.string.home_screen),
//            style = MarketKurlyTheme.typography.titleB22,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//        )
//        Button(
//            onClick = { navController.navigate(GOODS) },
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(top = 16.dp)
//        ) {
//            Text(
//                text = stringResource(R.string.btn_go_to_goods),
//                style = MarketKurlyTheme.typography.bodyB14
//            )
//        }