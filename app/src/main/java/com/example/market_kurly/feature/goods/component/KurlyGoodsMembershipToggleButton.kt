package com.example.market_kurly.feature.goods.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.core.util.price.calculateDiscountWithFloor
import com.example.market_kurly.core.util.price.toDecimalFormat
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.Mint1
import com.example.market_kurly.ui.theme.Mint3

@Composable
fun KurlyGoodsMembershipToggleButton(
    discount: Int,
    price: Int,
    itemId: String,
) {
    var expanded by rememberSaveable(itemId) { mutableStateOf(false) } // 리컴포지션 방지

    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium,
                ),
            ),
    ) {
        MembershipItemButton(
            expanded = expanded,
            onClick = { expanded = !expanded },
        )

        if (expanded) {
            MembershipPriceAndSubscribe(
                discount = discount,
                disCountPrice = price.calculateDiscountWithFloor(discount),
            )
        }
    }
}

@Composable
fun MembershipItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(vertical = 10.5.dp)
            .noRippleClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = stringResource(R.string.goods_text_membership),
            style = typography.bodyM16,
            color = Mint3,
        )
        Icon(
            imageVector = if (expanded) {
                ImageVector.vectorResource(R.drawable.icn_goods_arrow_down)
            } else ImageVector.vectorResource(R.drawable.icn_goods_arrow_up),
            contentDescription = stringResource(R.string.goods_icon_expand_membership_price_description),
            tint = Mint3,
        )
    }
}

@Composable
fun MembershipPriceAndSubscribe(
    discount: Int,
    disCountPrice: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .padding(bottom = 17.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(
                    R.string.goods_text_percent,
                    discount.toString(),
                ),
                style = typography.titleEmoji22,
                color = Mint3,
            )
            Text(
                text = stringResource(
                    R.string.goods_text_price,
                    disCountPrice.toDecimalFormat(),
                ),
                style = typography.titleEmoji22,
                color = Mint3,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    Mint3,
                    RoundedCornerShape(6.dp)
                )
                .clip(RoundedCornerShape(6.dp))
                .background(Mint1)
                .padding(vertical = 13.dp),
            horizontalArrangement = Arrangement.spacedBy(
                space = 2.dp,
                alignment = Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icn_goods_members),
                contentDescription = stringResource(R.string.goods_icon_membership_ticket_descrpition),
                tint = Color.Unspecified,
                modifier = Modifier.size(18.dp),
            )
            Text(
                text = stringResource(R.string.goods_text_membership_sub_string_1),
                style = typography.captionM12,
                color = Gray7,
            )
            Text(
                text = stringResource(
                    R.string.goods_text_price,
                    disCountPrice.toDecimalFormat(),
                ),
                style = typography.bodyB14,
                color = Mint3,
            )
            Text(
                text = stringResource(R.string.goods_text_membership_sub_string_2),
                style = typography.captionM12,
                color = Gray7,
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icn_goods_arrow_right),
                contentDescription = stringResource(R.string.goods_icon_right_arrow_description),
                modifier = Modifier.size(18.dp),
            )
        }
    }
}
