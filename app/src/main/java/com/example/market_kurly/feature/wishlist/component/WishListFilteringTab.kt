package com.example.market_kurly.feature.wishlist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.core.util.modifier.noRippleClickable
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.PrimaryColor400
import com.example.market_kurly.ui.theme.White

@Composable
fun WishListFilteringTab(
    modifier: Modifier = Modifier,
) {
    val categoryMenus = listOf("전체", "유제품", "간편식·밀키트·샐러드", "과일·견과·쌀", "간식·과자·떡")

    var selectedCategory by remember { mutableStateOf("전체") }

    Column {
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 18.dp)
        ) {
            items(categoryMenus.size) { index ->
                val category = categoryMenus[index]
                FilterChip(
                    modifier = Modifier
                        .height(32.dp)
                        .noRippleClickable { selectedCategory = category },
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = {
                        Text(
                            text = category,
                            style = MarketKurlyTheme.typography.captionR12
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = White,
                        labelColor = Gray6,
                        selectedContainerColor = PrimaryColor400,
                        selectedLabelColor = White
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        borderColor = Gray3,
                        borderWidth = 1.dp,
                        selectedBorderColor = PrimaryColor400,
                        selectedBorderWidth = 1.dp,
                        enabled = true,
                        selected = selectedCategory == category,
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishListFilteringTabPreview() {
    MARKETKURLYTheme {
        WishListFilteringTab(modifier = Modifier)
    }
}