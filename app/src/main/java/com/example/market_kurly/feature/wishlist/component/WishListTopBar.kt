package com.example.market_kurly.feature.wishlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun WishListTopBar(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "WishList TopBar Left Arrow",
            )

            Text(
                text = "찜한 상품",
                style = MarketKurlyTheme.typography.titleM18
            )
        }

        Row(
            modifier = modifier
                .align(Alignment.BottomEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_cart_icon),
                contentDescription = "WishList TopBar Notification",
            )

            Image(
                painter = painterResource(id = R.drawable.ic_notification_icon),
                contentDescription = "WishList TopBar Notification",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishListTopBarPreview() {
    MARKETKURLYTheme {
        WishListTopBar(modifier = Modifier)
    }
}