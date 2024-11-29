package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.CoolGray4
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor600

@Composable
fun HomeProductTitle (
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onDetailClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                title,
                style = MarketKurlyTheme.typography.titleB18,
                color = Gray8
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                subtitle,
                style = MarketKurlyTheme.typography.bodyR15,
                color = CoolGray4
            )
        }
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .noRippleClickable(onDetailClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "전체보기",
                style = MarketKurlyTheme.typography.captionR12,
                color = PrimaryColor600
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_home_arrow_right),
                contentDescription = stringResource(id = R.string.home_productTitleArrowRight_description),
                tint = PrimaryColor600
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeProductTitlePreview () {
    MARKETKURLYTheme {
        HomeProductTitle(
            "\uD83D\uDC51 껄디님을 위해 엄선했어요",
            "찜해 놓은 그 상품, 지금 빅세일로 저렴하게!"
        ) {}
    }
}