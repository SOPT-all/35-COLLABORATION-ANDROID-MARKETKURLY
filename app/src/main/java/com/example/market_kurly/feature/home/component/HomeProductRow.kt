package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.market_kurly.domain.model.ProductData


@Composable
fun HomeProductRow (
    products: List<ProductData>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        items(products) { product ->
            HomeProduct(
                product.name,
                product.price,
                product.discount,
                product.price,
                imageUrl = product.image,
                reviewCount = 999,
                onItemClick = {
                    navController.navigate("goods/${product.id}")
                }
            )
        }
    }
}

