package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.feature.home.ProductItem
import com.example.market_kurly.ui.theme.MARKETKURLYTheme



@Composable
fun HomeProductRow (
    products: List<ProductItem>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(7.dp) // 메뉴 간 간격
    ) {
        items(products) { product ->
            HomeProduct(
                product.title,
                product.discountBeforePrice,
                product.discountPercent,
                product.discountAfterPrice,
                product.reviewCount,
                imageUrl = product.imageUrl
            )
        }
    }
}

private val sampleProducts = listOf(
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    )

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

