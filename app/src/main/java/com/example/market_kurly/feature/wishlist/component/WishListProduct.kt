package com.example.market_kurly.feature.wishlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.CoolGray3
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor600
import com.example.market_kurly.ui.theme.Red
import com.example.market_kurly.ui.theme.White

@Composable
fun WishListProduct(
    imageUrl: String,
    productName: String,
    discountRate: String,
    discountedPrice: String,
    originalPrice: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = productName,
            modifier = modifier
                .size(96.dp)
                .aspectRatio(96f / 125f)
                .background(Gray6)
        )

        Spacer(modifier = modifier.width(16.dp))

        Column(
            modifier = modifier
                .height(125.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = productName,
                style = MarketKurlyTheme.typography.bodyR14,
                color = Gray8
            )

            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = discountRate,
                    style = MarketKurlyTheme.typography.bodyM16,
                    color = Red,
                    modifier = modifier.padding(end = 4.dp)
                )

                Text(
                    text = discountedPrice,
                    style = MarketKurlyTheme.typography.bodyM16,
                    color = Gray8,
                    modifier = modifier.padding(end = 4.dp)
                )

                Text(
                    text = originalPrice,
                    style = MarketKurlyTheme.typography.captionR12,
                    color = CoolGray3,
                    textDecoration = TextDecoration.LineThrough
                )
            }

            Spacer(modifier = modifier.width(16.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxSize()
                        .weight(1f)
                        .border(
                            1.dp,
                            Gray3,
                            RoundedCornerShape(4.dp)
                        )
                        .background(White)
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "삭제",
                        style = MarketKurlyTheme.typography.bodyM14,
                        color = Gray8
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxSize()
                        .weight(2f)
                        .border(
                            1.dp,
                            PrimaryColor600,
                            RoundedCornerShape(4.dp)
                        )
                        .background(White)
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_btn_add_to_cart),
                        contentDescription = "담기 버튼",
                        tint = PrimaryColor600,
                        modifier = modifier.size(18.dp)
                    )

                    Spacer(modifier = modifier.width(4.dp))

                    Text(
                        text = "담기",
                        style = MarketKurlyTheme.typography.bodyM14,
                        color = PrimaryColor600
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishListProductPreview() {
    MARKETKURLYTheme {
        WishListProduct(
            imageUrl = "",
            productName = "[프레지덩] 포션 버터 비가염 (10g X 20개입)",
            discountRate = "19%",
            discountedPrice = "7,273원",
            originalPrice = "8,980원",
            modifier = Modifier
        )
    }
}