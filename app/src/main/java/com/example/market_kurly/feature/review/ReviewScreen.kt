package com.example.market_kurly.feature.review

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun ReviewScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.review_screen),
            style = MarketKurlyTheme.typography.captionB12,
        )
    }
}
