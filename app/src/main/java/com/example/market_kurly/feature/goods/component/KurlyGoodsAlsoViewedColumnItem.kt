package com.example.market_kurly.feature.goods.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.market_kurly.R
import com.example.market_kurly.core.util.price.calculateDiscountWithFloor
import com.example.market_kurly.core.util.price.toDecimalFormat
import com.example.market_kurly.ui.theme.CoolGray2
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.Red
import com.example.market_kurly.ui.theme.White

@Composable
fun KurlyAlsoViewedColumnItem(
    image: String,
    goodsName: String,
    discount: Int,
    price: Int,
    onCartButtonClick: () -> Unit = {},
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterHorizontally,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(image)
                .build(),
            contentDescription = goodsName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(3.dp))
                .size(48.dp),
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = goodsName,
                style = typography.bodyR15,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Gray8,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(
                        R.string.goods_text_percent,
                        discount.toString(),
                    ),
                    style = typography.bodyM16,
                    color = Red,
                )
                Text(
                    text = stringResource(
                        R.string.goods_text_price,
                        price.calculateDiscountWithFloor(discount)
                            .toDecimalFormat(),
                    ),
                    style = typography.bodyM16,
                    color = Gray7,
                )
            }
        }
        Button(
            contentPadding = PaddingValues(horizontal = 8.5.dp, vertical = 6.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonColors(
                containerColor = White,
                contentColor = Gray7,
                disabledContainerColor = White,
                disabledContentColor = Gray7,
            ),
            border = BorderStroke(1.dp, CoolGray2),
            onClick = onCartButtonClick,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 4.dp,
                    alignment = Alignment.CenterHorizontally,
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.icon_cart_small),
                    contentDescription = stringResource(R.string.goods_btn_cart),
                    tint = Gray7,
                    modifier = Modifier.size(18.dp),
                )
                Text(
                    text = stringResource(R.string.goods_btn_cart),
                    style = typography.bodyR14,
                    color = Gray7,
                )
            }
        }
    }
}
