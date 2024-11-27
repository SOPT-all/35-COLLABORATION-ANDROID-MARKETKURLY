package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R


@Composable
fun HomeBannerRow (
    bannerList : List<String>,
    modifier : Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { bannerList.size }
    )
    HorizontalPager(
        pageSize = PageSize.Fill,
        state = pagerState,
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(0.dp),
    ) { page ->
        AsyncImageFillWidth(
            imageUrl = bannerList[page],
        )
    }
}