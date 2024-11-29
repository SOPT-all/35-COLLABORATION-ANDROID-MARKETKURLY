package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Black18
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.White
import kotlinx.coroutines.delay


@Composable
fun HomeBannerRow (
    bannerList : List<Int>,
    modifier : Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { bannerList.size }
    )

    LaunchedEffect(pagerState) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    HorizontalPager(
        pageSize = PageSize.Fill,
        state = pagerState,
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(0.dp),
    ) { page ->
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageFillWidth(image = bannerList[page])
            Text(
                text = "${page + 1} / ${bannerList.size}",
                style = MarketKurlyTheme.typography.captionM12,
                color = White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 17.dp, bottom = 16.dp)
                    .background(Black18, RoundedCornerShape(9999.dp))
                    .padding(vertical = 2.dp, horizontal = 7.dp)
            )
        }
    }
}

@Composable
private fun ImageFillWidth(
    @DrawableRes image: Int,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = stringResource(R.string.home_banner_description),
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}