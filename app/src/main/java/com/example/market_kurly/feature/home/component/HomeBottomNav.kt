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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray1
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.MARKETKURLYTheme


@Composable
fun HomeBottomNav (
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf("홈") }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Gray1)
            .drawBehind {
                val strokeWidth = 1.dp.toPx() // 선 두께
                drawLine(
                    color = Gray3,
                    start = Offset(0f, 0f), // 선 시작점 (좌측 상단)
                    end = Offset(size.width, 0f), // 선 끝점 (우측 상단)
                    strokeWidth = strokeWidth
                )
            }
            .padding(horizontal = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HomeNavItem(
            "홈",
            isSelected = selectedItem == "홈",
            R.drawable.ic_home_nav_home
        ) { selectedItem = "홈" }
        HomeNavItem(
            "라운지",
            isSelected = selectedItem == "라운지",
            R.drawable.ic_home_nav_lounge
        ) { selectedItem = "라운지" }
        HomeNavItem(
            "카테고리",
            isSelected = selectedItem == "카테고리",
            R.drawable.ic_home_nav_category
        ) { selectedItem = "카테고리" }
        HomeNavItem(
            "검색",
            isSelected = selectedItem == "검색",
            R.drawable.ic_home_nav_search
        ) { selectedItem = "검색" }
        HomeNavItem(
            "마이컬리",
            isSelected = selectedItem == "마이컬리",
            R.drawable.ic_home_nav_mykurly
        ) { selectedItem = "마이컬리" }
    }
}

@Preview
@Composable
private fun HomeBottomNavPreview() {
    MARKETKURLYTheme {
        HomeBottomNav()
    }
}