package com.example.market_kurly.core.util.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor600

@Composable
fun setDropDownMenuTextStyle(selectedFilter: String, filter: String): DropDownMenuTextStyle {
    val typography =
        if (selectedFilter == filter) {
            MarketKurlyTheme.typography.captionB12
        } else {
            MarketKurlyTheme.typography.captionM12
        }

    val color = if (selectedFilter == filter) PrimaryColor600 else Gray7
    return DropDownMenuTextStyle(color = color, typography = typography)
}

data class DropDownMenuTextStyle (
    val color: Color,
    val typography: TextStyle
)