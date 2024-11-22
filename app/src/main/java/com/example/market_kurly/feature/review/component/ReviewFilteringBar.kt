package com.example.market_kurly.feature.review.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.core.util.KeyStorage.REVIEW_FILTER_LEAST_STARS
import com.example.market_kurly.core.util.KeyStorage.REVIEW_FILTER_MOST_STARS
import com.example.market_kurly.core.util.KeyStorage.REVIEW_FILTER_RECENT
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.White

@Composable
fun ReviewFilteringBar(
    modifier: Modifier = Modifier
) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var selectedFilter by remember { mutableStateOf(REVIEW_FILTER_RECENT) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.review_total_number),
            style = MarketKurlyTheme.typography.captionM12,
            color = Gray7,
            modifier = Modifier.weight(1f)
        )

        Box {
            Text(
                text = selectedFilter,
                style = MarketKurlyTheme.typography.captionM12,
                color = Gray7,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 14.dp)
                    .then(
                        Modifier.clickable {
                            isDropDownMenuExpanded = !isDropDownMenuExpanded
                        }
                    )
            )

            DropdownMenu(
                expanded = isDropDownMenuExpanded,
                onDismissRequest = { isDropDownMenuExpanded = false },
                modifier = modifier
                    .background(White)
            ) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.review_filter_recent)) },
                    onClick = {
                        selectedFilter = REVIEW_FILTER_RECENT
                        isDropDownMenuExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.review_filter_most_stars)) },
                    onClick = {
                        selectedFilter = REVIEW_FILTER_MOST_STARS
                        isDropDownMenuExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.review_filter_least_stars)) },
                    onClick = {
                        selectedFilter = REVIEW_FILTER_LEAST_STARS
                        isDropDownMenuExpanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewFilteringBarPreview() {
    MARKETKURLYTheme {
        ReviewFilteringBar(modifier = Modifier)
    }
}