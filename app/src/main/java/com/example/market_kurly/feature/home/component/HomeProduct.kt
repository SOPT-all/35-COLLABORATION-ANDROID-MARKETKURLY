package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.core.util.price.toDecimalFormat
import com.example.market_kurly.ui.theme.CoolGray3
import com.example.market_kurly.ui.theme.Gray8
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
    onPutInClick: () -> Unit = {},
    onItemClick: () -> Unit = {}
) {
    Column (
        modifier = modifier
            .width(140.dp)
            .noRippleClickable(onItemClick),
    ) {
        AsyncImageFillWidth(
            imageUrl = imageUrl,
            modifier = Modifier.clip(RoundedCornerShape(4.dp)),
        )
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
            stringResource(id = R.string.home_price, discountBeforePrice.toDecimalFormat()),
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
                stringResource(id = R.string.home_price, discountAfterPrice.toDecimalFormat()),
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
                stringResource(id = R.string.home_review_count, if (reviewCount > 9999) 9999 else if(reviewCount > 999) 999 else reviewCount),
                style = MarketKurlyTheme.typography.captionR12,
                color = CoolGray3
            )
        }
    }
}