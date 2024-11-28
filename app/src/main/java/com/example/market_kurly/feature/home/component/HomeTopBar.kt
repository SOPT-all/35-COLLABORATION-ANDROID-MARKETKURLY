package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor500
import com.example.market_kurly.ui.theme.PrimaryColor600
import com.example.market_kurly.ui.theme.PrimaryColor700
import com.example.market_kurly.ui.theme.White

@Composable
fun HomeTopBar (
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(PrimaryColor600)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 15.dp,
                    end = 10.dp,
                    top = 38.dp,
                    bottom = 14.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.mipmap.img_home_logo),
                contentDescription = stringResource(R.string.home_kurlyLogo_description)
            )
            HomeTopBarToggle()
            Row {
                HomeIcon(
                    icon = R.drawable.ic_home_notification,
                    contentDescription = stringResource(id = R.string.home_notification_description)
                )
                Spacer(modifier.width(19.dp))
                HomeIcon(
                    icon = R.drawable.ic_home_cart,
                    contentDescription = stringResource(id = R.string.home_cart_description)
                )
                Spacer(modifier.width(9.dp))
            }
        }
        HomeTopTabBar()
    }
}

@Composable
private fun HomeTopBarToggle(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(PrimaryColor500),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.home_topbar_marketkurly),
            style = MarketKurlyTheme.typography.captionB12,
            color = PrimaryColor600,
            modifier = modifier
                .clip(CircleShape)
                .background(White)
                .padding(
                    horizontal = 9.5.dp,
                    vertical = 5.dp
                )
        )
        Text(
            text = stringResource(id = R.string.home_topbar_beatykurly),
            style = MarketKurlyTheme.typography.captionR12,
            color = White,
            modifier = modifier
                .padding(
                    start = 8.dp,
                    end = 10.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
        )

    }
}

@Composable
private fun HomeIcon(
    @DrawableRes icon: Int,
    contentDescription : String
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        tint = Color.White,
    )
}

@Composable
private fun HomeTopTabBar() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabTitles = listOf("컬러추천", "베스트", "신상품", "알뜰쇼핑", "특가/혜택")

    Surface(
        modifier = Modifier.fillMaxWidth().height(44.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .drawBehind {
                            val borderSize = 2.dp.toPx()
                            val borderColor = PrimaryColor700
                            drawLine(
                                color = if (selectedTabIndex == index) borderColor else White,
                                start = Offset(0f, size.height - borderSize / 2),
                                end = Offset(size.width, size.height - borderSize / 2),
                                strokeWidth = borderSize
                            )
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        color = if (selectedTabIndex == index) PrimaryColor700 else Gray6,
                        style = MarketKurlyTheme.typography.bodyM14,
                        modifier = Modifier
                            .noRippleClickable { selectedTabIndex = index }
                            .padding(horizontal = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    MARKETKURLYTheme {
        HomeTopBar()
    }
}


