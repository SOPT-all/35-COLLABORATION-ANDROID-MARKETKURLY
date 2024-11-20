package com.example.market_kurly.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.PrimaryColor600
import com.example.market_kurly.ui.theme.White

@Composable
fun KurlyProductsDetailBottomBar(
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBuyingButtonClick: () -> Unit = {}
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
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            contentPadding = PaddingValues(horizontal = 11.dp, vertical = 11.dp),
            onClick = onFavoriteClick,
            shape = RoundedCornerShape(5.dp),
            colors = ButtonColors(
                containerColor = White,
                contentColor = Color.Unspecified,
                disabledContainerColor = White,
                disabledContentColor = Color.Unspecified
            ),
            border = BorderStroke(1.dp, Gray3)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(favoriteResource),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(27.dp)
            )
        }
        Button(
            contentPadding = PaddingValues(horizontal = 11.dp),
            onClick = onBuyingButtonClick,
            shape = RoundedCornerShape(6.dp),
            colors = ButtonColors(
                containerColor = PrimaryColor600,
                contentColor = White,
                disabledContainerColor = PrimaryColor600,
                disabledContentColor = White
            ),
            modifier = Modifier
                .weight(1f)
                .height(IntrinsicSize.Max)
        ) {
            Text(
                text = "구매하기",
                style = typography.titleM18,
                color = White
            )
        }
    }
}