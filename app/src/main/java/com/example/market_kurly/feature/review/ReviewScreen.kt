package com.example.market_kurly.feature.review

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.R
import com.example.market_kurly.feature.review.component.ReviewFilteringBar
import com.example.market_kurly.feature.review.component.ReviewImageRow
import com.example.market_kurly.feature.review.component.ReviewItem
import com.example.market_kurly.feature.review.component.ReviewNoticeItem
import com.example.market_kurly.ui.theme.Gray2
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.White

@Composable
fun ReviewScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ReviewViewModel = viewModel()
) {

    val reviews = viewModel.reviews

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 30.dp)
    ) {
        ReviewNoticeItem(
            text = stringResource(R.string.review_notice_best_review)
        )

        Spacer(modifier = modifier.height(6.dp))

        ReviewNoticeItem(
            text = stringResource(R.string.review_notice_savings_rule)
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(
            text = stringResource(R.string.review_photo_review),
            style = MarketKurlyTheme.typography.bodyM14,
            color = Gray7,
            modifier = modifier.padding(start = 16.dp)
        )

        ReviewImageRow(
            imageUrls = listOf(
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81"
            ),
            modifier = modifier
                .padding(start = 16.dp, top = 8.dp)
        )

        Spacer(modifier = modifier.height(15.dp))

        Spacer(
            modifier = modifier
                .height(8.dp)
                .fillMaxWidth()
                .background(Gray2)
        )

        ReviewFilteringBar()

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(White)
        ) {
            itemsIndexed(reviews) { index, review ->

                Column {
                    ReviewItem(
                        userName = review.userName,
                        productName = review.productName,
                        imageUrls = review.imageUrls,
                        reviewText = review.reviewText,
                        reviewDate = review.reviewDate,
                        starCount = review.starCount,
                        modifier = modifier.padding(bottom = 16.dp)
                    )

                    if (index < reviews.size - 1) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Gray2
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewScreenPreview() {
    MARKETKURLYTheme {
        ReviewScreen(modifier = Modifier, navController = rememberNavController())
    }
}