package com.example.market_kurly.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.InteractionSource.rememberEmptyInteractionSource
import com.example.market_kurly.core.util.KeyStorage
import com.example.market_kurly.core.util.modifier.customTabIndicatorOffset
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.PrimaryColor600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KurlyGoodsDetailTopBar(
    goodsName: String,
    selectedIndex: Int,
    navigateUp: () -> Unit,
    navigateToGoodsDetail: () -> Unit,
    navigateGoodsReview: () -> Unit,
    navigateToCart: () -> Unit = {},
) {
    var selectedTabIndex by remember { mutableIntStateOf(selectedIndex) }
    Column {
        CenterAlignedTopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = goodsName,
                    style = typography.titleM18,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Gray8,
                    modifier = Modifier.weight(1f),
                )
            },
            navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icn_arrow_left),
                        contentDescription = stringResource(R.string.kurly_icon_navigate_up_description),
                        tint = Gray7,
                        modifier = Modifier.size(48.dp)
                            .noRippleClickable(navigateUp),
                    )
            },
            actions = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icn_cart_large),
                        contentDescription = stringResource(R.string.kurly_icon_navigate_cart_description),
                        tint = Gray8,
                        modifier = Modifier.size(48.dp)
                            .noRippleClickable(navigateToCart),
                    )
            },
        )
        KurlyGoodsDetailTabRow(
            tabs = KeyStorage.ALL_TABS,
            selectedTabIndex = selectedTabIndex,
        ) { index ->
            selectedTabIndex = index
            when (KeyStorage.ALL_TABS[index]) {
                KeyStorage.GOODS_DETAIL -> navigateToGoodsDetail()
                KeyStorage.GOODS_REVIEWS -> navigateGoodsReview()
            }
        }
    }
}

@Composable
fun KurlyGoodsDetailTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val tabWidth = screenWidth / tabs.size

    ScrollableTabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = selectedTabIndex,
        contentColor = Gray6,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex],
                    tabWidth = tabWidths[selectedTabIndex],
                ),
                color = PrimaryColor600,
            )
        },
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            val selectedColor = if (selectedTabIndex == tabIndex) PrimaryColor600 else Gray6

            Tab(
                modifier = Modifier.width(tabWidth),
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                interactionSource = rememberEmptyInteractionSource(),
                text = {
                    Text(
                        text = tab,
                        style = typography.bodyM14,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        },
                        color = selectedColor,
                    )
                },
            )
        }
    }
}
