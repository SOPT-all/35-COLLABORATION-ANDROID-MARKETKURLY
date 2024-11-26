package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.Red
import com.example.market_kurly.ui.theme.White

@Composable
fun HomeRankingProduct (
    ranking: Int,
    productTitle: String,
    discountPercent: Int,
    discountAfterPrice: Int,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    onPutInClick: () -> Unit = {}
) {
    Column (
        modifier = modifier
            .width(177.dp)
            .background(White, shape = RoundedCornerShape(10.dp))
    ) {
        AsyncImageFillWidth(
            imageUrl = imageUrl,
            modifier = Modifier.clip(RoundedCornerShape(4.dp)),
            placeholder = R.mipmap.img_home_ranking_product_dummy
        )
        Spacer(modifier = Modifier.height(6.dp))
        Column(
            modifier = Modifier
                .padding(
                start = 11.dp,
                end = 11.dp,
                top = 21.dp,
                bottom = 12.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    ranking.toString(),
                    style = MarketKurlyTheme.typography.titleB22.copy(
                        fontSize = 30.sp
                    ),
                    color = Gray8
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        productTitle,
                        style = MarketKurlyTheme.typography.bodyR14,
                        color = Gray8
                    )
                    Row() {
                        Text(
                            stringResource(id = R.string.home_percent, discountPercent),
                            style = MarketKurlyTheme.typography.bodyB16,
                            color = Red
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            stringResource(id = R.string.home_price, discountAfterPrice),
                            style = MarketKurlyTheme.typography.bodyB16,
                            color = Gray8
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            HomePutInButton (
                modifier = Modifier.fillMaxWidth()
            ) { onPutInClick() }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeRankingProductPreview() {
    MARKETKURLYTheme {
        HomeRankingProduct(
            ranking = 1,
            productTitle = "[사미헌] 갈비탕",
            discountPercent = 15,
            discountAfterPrice = 11050,
            imageUrl = "https://velog.velcdn.com/images/roel_dev/post/7b723d45-14a7-45a9-b489-f6cbc9c2035e/image.png",
        ) {}
    }
}