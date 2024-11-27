package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.domain.model.ProductData
import com.example.market_kurly.ui.theme.MARKETKURLYTheme


@Composable
fun HomeProductRow (
    products: List<ProductData>,
    modifier: Modifier = Modifier
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
                reviewCount = 999
            )
        }
    }
}

private val sampleProducts = listOf(
    ProductData(1, "제주 무농약 감귤 2kg (15~20입)", 15900, 19, "https://raw.githubusercontent.com/bigmacfive/sopt-joint-seminars/refs/heads/main/product/1.png"),
    ProductData(2, "[비비고] 왕교자 만두 대용량 1.05kg", 10480, 5, "https://raw.githubusercontent.com/bigmacfive/sopt-joint-seminars/refs/heads/main/product/2.png"),
    ProductData(3, "[유기농] 베이비 브로콜리 2단 (150g×2입)", 9900, 20, "https://raw.githubusercontent.com/bigmacfive/sopt-joint-seminars/refs/heads/main/product/3.png"),
    ProductData(4, "[프리미엄] 샤인머스켓 포도 1kg (1~2송이)", 29900, 17, "https://raw.githubusercontent.com/bigmacfive/sopt-joint-seminars/refs/heads/main/product/4.png"),
)

@Preview(showBackground = true)
@Composable
private fun HomeProductRowPreview () {
    MARKETKURLYTheme {
        HomeProductRow(
            sampleProducts
        )
    }
}

