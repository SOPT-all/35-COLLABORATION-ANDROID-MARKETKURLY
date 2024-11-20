package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.CoolGray1
import com.example.market_kurly.ui.theme.CoolGray5
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme


@Composable
fun TagMenu (
    menu: String,
    @DrawableRes icon: Int,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Tag Item",
            tint = Color.Unspecified,
            modifier = Modifier
                .background(color = CoolGray1, shape = RoundedCornerShape(16.dp))
                .padding(7.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            menu,
            style = MarketKurlyTheme.typography.captionM11,
            color = CoolGray5
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TagMenuPreview() {
    MARKETKURLYTheme {
        TagMenu(
            "최저가도전",
            R.drawable.ic_home_lowestprice
        )
    }
}