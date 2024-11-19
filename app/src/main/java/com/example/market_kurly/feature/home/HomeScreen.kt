package com.example.market_kurly.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.market_kurly.R
import com.example.market_kurly.core.util.KeyStorage.GOODS
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.home_screen),
            style = MarketKurlyTheme.typography.titleB22,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = { navController.navigate(GOODS) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.btn_go_to_goods),
                style = MarketKurlyTheme.typography.bodyB14
            )
        }
    }
}