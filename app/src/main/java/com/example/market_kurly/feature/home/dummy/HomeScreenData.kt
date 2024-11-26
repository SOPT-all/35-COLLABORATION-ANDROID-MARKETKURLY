package com.example.market_kurly.feature.home.dummy

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.market_kurly.R
import com.example.market_kurly.feature.home.TagItem

@Composable
fun HomeScreenData(): List<TagItem> {
    return listOf(
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
}