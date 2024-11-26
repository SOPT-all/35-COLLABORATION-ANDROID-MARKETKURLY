package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.feature.home.NavItem
import com.example.market_kurly.ui.theme.Gray1
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.MARKETKURLYTheme


@Composable
fun HomeBottomNav (
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf(context.getString(R.string.home_buttonNav_home))}
    val navItems = listOf(
        NavItem(stringResource(id = R.string.home_buttonNav_home), R.drawable.ic_home_nav_home),
        NavItem(stringResource(id = R.string.home_buttonNav_lounge), R.drawable.ic_home_nav_lounge),
        NavItem(stringResource(id = R.string.home_buttonNav_category), R.drawable.ic_home_nav_category),
        NavItem(stringResource(id = R.string.home_buttonNav_search), R.drawable.ic_home_nav_search),
        NavItem(stringResource(id = R.string.home_buttonNav_mykurly), R.drawable.ic_home_nav_mykurly)
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray1)
            .drawBehind {
                val strokeWidth = 1.dp.toPx() // 선 두께
                drawLine(
                    color = Gray3,
                    start = Offset(0f, 0f), // 선 시작점 (좌측 상단)
                    end = Offset(size.width, 0f), // 선 끝점 (우측 상단)
                    strokeWidth = strokeWidth
                )
            }
            .padding(
                start = 18.dp,
                end = 18.dp,
                bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        navItems.forEach { item ->
            HomeNavItem(
                item.title,
                isSelected = selectedItem == item.title,
                icon = item.icon
            ) { selectedItem =  item.title }
        }
    }
}

@Preview
@Composable
private fun HomeBottomNavPreview() {
    MARKETKURLYTheme {
        HomeBottomNav()
    }
}