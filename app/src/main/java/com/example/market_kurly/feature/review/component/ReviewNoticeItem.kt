package com.example.market_kurly.feature.review.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun ReviewNoticeItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_review_notice),
            contentDescription = stringResource(R.string.review_notice_icon_description),
            modifier = modifier
                .size(30.dp),
        )

        Spacer(modifier = modifier.width(8.dp))

        Text(
            text = text,
            style = MarketKurlyTheme.typography.bodyR15,
            color = Gray7,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewNoticeItemPreview() {
    MARKETKURLYTheme {
        ReviewNoticeItem(
            text = "[24년 11월 1주] 베스트 후기 선정 안내",
            modifier = Modifier,
        )
    }
}
