package com.example.market_kurly.core.designsystem.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.KeyStorage
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.Gray8
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.PrimaryColor600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KurlyProductsDetailTopBar(
    goodsName: String,
    selectedIndex : Int,
    navigateUp: () -> Unit,
    navigateToGoodsDescription: () -> Unit,
    navigateGoodsReview: () -> Unit,
    navigateToCart: () -> Unit = {}
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
                        modifier = Modifier.weight(1f)
                    )
            },
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(
                        painter = painterResource(id = R.drawable.icn_arrow_left),
                        contentDescription = "Left Icon",
                        modifier = Modifier.size(48.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = navigateToCart) {
                    Icon(
                        painter = painterResource(id = R.drawable.icn_cart_large),
                        contentDescription = "Right Icon",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        )
        KurlyProductsDetailTabRow(
            tabs = KeyStorage.ALL_TABS,
            selectedTabIndex = selectedTabIndex
        ) { index ->
            selectedTabIndex = index
            when (KeyStorage.ALL_TABS[index]) {
                KeyStorage.GOODS_DESCRIPTION -> navigateToGoodsDescription()
                KeyStorage.GOODS_REVIEWS -> navigateGoodsReview()
                else -> {}
            }
        }
    }
}
@Composable
fun KurlyProductsDetailTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
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
                    tabWidth = tabWidths[selectedTabIndex]
                ),
                color = PrimaryColor600
            )
        }
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            val selectedColor = if (selectedTabIndex == tabIndex) PrimaryColor600 else Gray6

            Tab(
                modifier = Modifier.width(tabWidth),
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
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
                }
            )
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}
@Preview(showBackground = true)
@Composable
fun PreviewTopBarWithIndicator() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    KurlyProductsDetailTabRow(KeyStorage.ALL_TABS, selectedTabIndex) { tabIndex ->
        selectedTabIndex = tabIndex
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewKurlyProductsDetailTopBar() {
    KurlyProductsDetailTopBar("아삭하고 달콤한 황금사과1.3kg (5~7입)[품종:시나노골드]", KeyStorage.ALL_TABS.indexOf(KeyStorage.GOODS_DESCRIPTION), {}, {}, {})
}