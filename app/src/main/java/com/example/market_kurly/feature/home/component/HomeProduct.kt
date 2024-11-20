package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.CoolGray3
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.Red


@Composable
fun HomeProduct (
    productTitle: String,
    discountBeforePrice: Int,
    discountPercent: Int,
    discountAfterPrice: Int,
    reviewCount: Int,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    onPutInClick: () -> Unit = {}
) {
    Column (
        modifier = modifier.width(140.dp)
    ) {
        HomeProductImage(imageUrl)
        Spacer(modifier = Modifier.height(6.dp))
        HomePutInButton { onPutInClick() }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            productTitle,
            style = MarketKurlyTheme.typography.bodyR14,
            color = Gray8
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            stringResource(id = R.string.home_price, discountBeforePrice),
            style = MarketKurlyTheme.typography.captionR12.copy(
                textDecoration = TextDecoration.LineThrough
            ),
            color = CoolGray3
        )
        Row() {
            Text(
                stringResource(id = R.string.home_percent, discountPercent),
                style = MarketKurlyTheme.typography.bodyB16,
                color = Red
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                stringResource(id = R.string.home_price, discountAfterPrice),
                style = MarketKurlyTheme.typography.bodyB16,
                color = Gray8
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home_review),
                contentDescription = "Home Product Review",
                tint = CoolGray3
            )
            Text(
                stringResource(id = R.string.home_review_count, if (reviewCount > 999) 999 else reviewCount),
                style = MarketKurlyTheme.typography.captionR12,
                color = CoolGray3
            )
        }
    }
}

@Composable
private fun HomeProductImage (
    imageUrl: String? = null
) {
    val context = LocalContext.current
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        model = ImageRequest.Builder(context).data(imageUrl)
            .placeholder(R.mipmap.img_home_product_dummy)
            .error(R.mipmap.img_home_product_dummy)
            .build(),
        contentDescription = "Home Banner",
        placeholder = painterResource(id = R.mipmap.img_home_product_dummy),
        onError = {},
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeProductPreview() {
    MARKETKURLYTheme {
        HomeProduct(
            "[3개 사면 33%] 비비고 통새우만두 200g",
            6980,
            33,
            4630,
            1200,
        )
    }
}