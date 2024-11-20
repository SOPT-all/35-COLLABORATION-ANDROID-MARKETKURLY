package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.feature.home.ProductItem
import com.example.market_kurly.ui.theme.MARKETKURLYTheme


@Composable
fun HomeRankingProductRow (
    products: List<ProductItem>,
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
                productTitle = product.title,
                discountPercent = product.discountPercent,
                discountAfterPrice = product.discountAfterPrice,
                imageUrl = product.imageUrl
            )
        }
    }
}

private val sampleProducts = listOf(
    ProductItem(
        title = "[사미헌] 갈비탕 ",
        imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/0b844970-d88e-4dec-a8ee-fcd3fa88e415/img_home_ranking_product_dummy.png",
        discountBeforePrice = 13000,
        discountPercent = 15,
        discountAfterPrice = 11050,
    ),
    ProductItem(
        title = "[사미헌] 갈비탕 ",
        imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/0b844970-d88e-4dec-a8ee-fcd3fa88e415/img_home_ranking_product_dummy.png",
        discountBeforePrice = 13000,
        discountPercent = 15,
        discountAfterPrice = 11050,
    ),
    ProductItem(
        title = "[사미헌] 갈비탕 ",
        imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/0b844970-d88e-4dec-a8ee-fcd3fa88e415/img_home_ranking_product_dummy.png",
        discountBeforePrice = 13000,
        discountPercent = 15,
        discountAfterPrice = 11050,
    ),
    ProductItem(
        title = "[사미헌] 갈비탕 ",
        imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/0b844970-d88e-4dec-a8ee-fcd3fa88e415/img_home_ranking_product_dummy.png",
        discountBeforePrice = 13000,
        discountPercent = 15,
        discountAfterPrice = 11050,
    ),
    ProductItem(
        title = "[사미헌] 갈비탕 ",
        imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/0b844970-d88e-4dec-a8ee-fcd3fa88e415/img_home_ranking_product_dummy.png",
        discountBeforePrice = 13000,
        discountPercent = 15,
        discountAfterPrice = 11050,
    ),
)

@Preview
@Composable
private fun HomeRankingProductRowPreview() {
    MARKETKURLYTheme {
        HomeRankingProductRow(
            sampleProducts
        )
    }
}