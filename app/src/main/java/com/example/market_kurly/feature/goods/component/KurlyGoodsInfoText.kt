package com.example.market_kurly.feature.goods.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography

@Composable
fun KurlyGoodsInfoText(
    modifier: Modifier,
    infoTitle: String,
    infoContent: String,
    infoSubContent: String? = null,

) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = infoTitle,
            style = typography.bodyM14,
            color = Gray6,
            modifier = Modifier.weight(0.25f)
                .padding(end = 20.dp),
        )
        Column(
            modifier = Modifier.weight(0.75f),
        ) {
            Text(
                text = infoContent,
                style = typography.bodyR14,
                color = Gray8,
            )
            infoSubContent?.let {
                Text(
                    text = infoSubContent,
                    style = typography.bodyR14,
                    color = Gray6,
                )
            }
        }
    }
}
