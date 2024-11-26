package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
            ) {
                items(group) { tag ->
                    HomeTagItem(
                        tag = tag.tag,
                        icon = tag.icon
                    )
                }
            }
        }
    }
}



@Preview
@Composable
private fun HomeTagItemRowPreview() {
    val sampleTags = listOf(
        TagItem(stringResource(id = R.string.home_tag_lowestprice), R.drawable.ic_home_lowestprice),
        TagItem(stringResource(id = R.string.home_tag_members), R.drawable.ic_home_members),
        TagItem(stringResource(id = R.string.home_tag_homeliving), R.drawable.ic_home_homeliving),
        TagItem(stringResource(id = R.string.home_tag_fashion), R.drawable.ic_home_fashion),
        TagItem(stringResource(id = R.string.home_tag_present), R.drawable.ic_home_present),
        TagItem(stringResource(id = R.string.home_tag_livecommerce), R.drawable.ic_home_livecommerce),
        TagItem(stringResource(id = R.string.home_tag_kurlymembers), R.drawable.ic_home_kurlymembers),
        TagItem(stringResource(id = R.string.home_tag_kurlycurator), R.drawable.ic_home_kurlycurator),
        TagItem(stringResource(id = R.string.home_tag_luck), R.drawable.ic_home_luck),
        TagItem(stringResource(id = R.string.home_tag_todaytarot), R.drawable.ic_home_todaytarot),
        TagItem(stringResource(id = R.string.home_tag_mykurlyfarm), R.drawable.ic_home_mykurlyfarm),
        TagItem(stringResource(id = R.string.home_tag_showcase), R.drawable.ic_home_showcase),
    )
    MARKETKURLYTheme {
        HomeTagItemRow(sampleTags)
    }
}