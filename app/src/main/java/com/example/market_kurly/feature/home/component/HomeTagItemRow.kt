package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.feature.home.TagItem
import com.example.market_kurly.ui.theme.MARKETKURLYTheme


@Composable
fun HomeTagItemRow (
    tagList: List<TagItem>,
) {
    val chunkedList = tagList.chunked(6)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 11.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        chunkedList.forEach { group ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp) // 메뉴 간 간격
            ) {
                items(group) { tag ->
                    TagItem(
                        tag = tag.tag,
                        icon = tag.icon
                    )
                }
            }
        }
    }
}

private val sampleTags = listOf(
    TagItem("최저가도전", R.drawable.ic_home_lowestprice),
    TagItem("멤버스특가", R.drawable.ic_home_members),
    TagItem("홈&리빙", R.drawable.ic_home_homeliving),
    TagItem("패션", R.drawable.ic_home_fashion),
    TagItem("선물추천", R.drawable.ic_home_present),
    TagItem("라이브커머스", R.drawable.ic_home_livecommerce),
    TagItem("컬리멤버스", R.drawable.ic_home_kurlymembers),
    TagItem("컬리큐레이터", R.drawable.ic_home_kurlycurator),
    TagItem("행운출첵", R.drawable.ic_home_luck),
    TagItem("오늘의타로", R.drawable.ic_home_todaytarot),
    TagItem("마이컬리맘", R.drawable.ic_home_mykurlyfarm),
    TagItem("쇼케이스", R.drawable.ic_home_showcase),
)

@Preview
@Composable
private fun HomeTagItemRowPreview() {
    MARKETKURLYTheme {
        HomeTagItemRow(sampleTags)
    }
}