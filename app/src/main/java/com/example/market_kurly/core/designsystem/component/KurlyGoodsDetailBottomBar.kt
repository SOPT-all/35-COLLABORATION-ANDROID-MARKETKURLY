package com.example.market_kurly.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.PrimaryColor600
import com.example.market_kurly.ui.theme.White

@Composable
fun KurlyGoodsDetailBottomBar(
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBuyingButtonClick: () -> Unit = {},
) {
    val favoriteResource = if (isFavorite) {
        R.drawable.icn_favorite_activate
    } else {
        R.drawable.icn_favorite_default
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(13.dp, 16.dp, 13.dp, 11.dp)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 7.dp,
            alignment = Alignment.CenterHorizontally,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(favoriteResource),
            contentDescription = stringResource(R.string.kurly_icon_favorite_description),
            tint = Color.Unspecified,
            modifier = Modifier
                .border(
                    1.dp,
                    Gray3,
                    RoundedCornerShape(5.dp),
                )
                .clip(RoundedCornerShape(5.dp))
                .background(White)
                .padding(horizontal = 12.dp, vertical = 11.dp)
                .noRippleClickable(onFavoriteClick),
        )
        Text(
            text = stringResource(R.string.kurly_btn_buying),
            style = typography.titleM18,
            color = White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(6.dp))
                .background(PrimaryColor600)
                .padding(vertical = 11.dp)
                .noRippleClickable(onBuyingButtonClick),
        )
    }
}
