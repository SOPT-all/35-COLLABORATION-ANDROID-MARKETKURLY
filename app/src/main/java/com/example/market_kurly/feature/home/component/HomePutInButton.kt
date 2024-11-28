package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.market_kurly.ui.theme.CoolGray2
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.White

@Composable
fun HomePutInButton (
    modifier: Modifier = Modifier,
    onPutInClick: () -> Unit = {}
){
    Box (
        modifier = modifier
            .fillMaxWidth()
            .background(White, shape = RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = CoolGray2, shape = RoundedCornerShape(4.dp))
            .noRippleClickable(onPutInClick)
            .padding(vertical = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home_cart_18),
                contentDescription = stringResource(id = R.string.home_putInButton_description),
                tint = Gray7
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                stringResource(id = R.string.home_put_in),
                style = MarketKurlyTheme.typography.bodyR14,
                maxLines = 1,
                color = Gray7
            )
        }
    }
}

@Preview
@Composable
private fun HomePutInButtonPreview () {
    MARKETKURLYTheme {
        HomePutInButton()
    }
}