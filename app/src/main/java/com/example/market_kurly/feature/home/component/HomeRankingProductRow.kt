package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.market_kurly.domain.model.ProductUiData


@Composable
fun HomeRankingProductRow (
    products: List<ProductUiData>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        itemsIndexed(products) { index, product ->
            HomeRankingProduct(
                ranking = index + 1,
                productTitle = product.name,
                discountPercent = product.discount,
                discountAfterPrice = product.price,
                imageUrl = product.image
            )
        }
    }
}