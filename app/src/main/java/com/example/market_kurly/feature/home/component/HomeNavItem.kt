package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor600

@Composable
fun HomeNavItem (
    menu: String,
    @DrawableRes icon : Int,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column (
        modifier = Modifier.size(48.dp)
            .noRippleClickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Home Nav Icon",
            tint = if (isSelected) PrimaryColor600 else Gray7
        )
        Text(
            menu,
            style = MarketKurlyTheme.typography.captionM9,
            color = if (isSelected) PrimaryColor600 else Gray7
        )
    }
}