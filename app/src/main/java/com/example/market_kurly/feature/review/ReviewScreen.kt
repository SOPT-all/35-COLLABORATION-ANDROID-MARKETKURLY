package com.example.market_kurly.feature.review

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.feature.review.component.ReviewImageRow
import com.example.market_kurly.ui.theme.MARKETKURLYTheme

@Composable
fun ReviewScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ReviewImageRow(
            imageUrls = listOf(
                "https://via.placeholder.com/81",
                "https://via.placeholder.com/81",
                "https://via.placeholder.com/81",
                "https://via.placeholder.com/81",
                "https://via.placeholder.com/81",
                "https://via.placeholder.com/81"
            ),
            modifier = modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewScreenPreview() {
    MARKETKURLYTheme {
        ReviewScreen(modifier = Modifier, navController = rememberNavController())
    }
}