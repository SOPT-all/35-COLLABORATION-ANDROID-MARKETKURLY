package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.CoolGray1
import com.example.market_kurly.ui.theme.CoolGray5
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme


@Composable
fun HomeTagItem (
    tag: String,
    @DrawableRes icon: Int,
) {
    Column (
        modifier = Modifier
            .width(61.dp)
            .height(65.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = stringResource(id = R.string.home_tagItem_description),
            tint = Color.Unspecified,
            modifier = Modifier
                .background(CoolGray1, shape = RoundedCornerShape(13.dp))
                .padding(7.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            tag,
            style = MarketKurlyTheme.typography.captionM11,
            color = CoolGray5,
            textAlign = TextAlign.Center, // 텍스트 중앙 정렬
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TagMenuPreview() {
    MARKETKURLYTheme {
        HomeTagItem(
            "컬리큐레이터",
            R.drawable.ic_home_lowestprice
        )
    }
}