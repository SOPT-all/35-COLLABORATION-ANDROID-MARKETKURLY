package com.example.market_kurly.feature.review

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.R
import com.example.market_kurly.data.dummy.ReviewData
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
    modifier: Modifier = Modifier
) {
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
            items(dummyReviews) { review ->
                ReviewItem(
                    userName = review.userName,
                    productName = review.productName,
                    reviewText = review.reviewText,
                    reviewDate = review.reviewDate,
                    starCount = review.starCount,
                    modifier = Modifier.padding(bottom = 16.dp) // 각 아이템 간 간격
                )
            }
        }
    }
}

val dummyReviews = listOf(
    ReviewData(
        userName = "신**",
        productName = "시나노골드 (금사과) 1.3kg (5~7입)",
        reviewText = "요즘 사과 품종별로 비교해보는 재미에 빠졌어요. 감홍의 맛을 가장 좋아하긴 하는데 맛 비교 자체가 너무 즐거워요.\n" +
                "시나노골드는 처음 먹어보는데 황금사과라는 이름에 걸맞게 정말 금색이에요 ㅎㅎ\n" +
                "일단은 그냥 온전히 껍질째 먹었어요. 확실히 연한 느낌이에요. 껍질도 과육도요.\n" +
                "감홍이 깊은 단맛과 향이라면 이거는 싱그러운 단맛과 향이에요.",
        reviewDate = "2022.11.15",
        starCount = 4
    ),
    ReviewData(
        userName = "박**",
        productName = "부사 (사과) 2kg (6~8입)",
        reviewText = "사과가 정말 아삭아삭하고 맛있었어요. 껍질이 얇아서 그냥 먹기에도 부담 없고 단맛이 강해서 아이들도 좋아했어요.",
        reviewDate = "2022.11.10",
        starCount = 5
    ),
    ReviewData(
        userName = "김**",
        productName = "청송사과 (사과) 1.5kg (5~7입)",
        reviewText = "사과는 항상 청송사과가 최고죠! 신선도도 좋고 맛도 좋습니다. 추천합니다.",
        reviewDate = "2022.11.01",
        starCount = 3
    )
)

@Preview(showBackground = true)
@Composable
fun ReviewScreenPreview() {
    MARKETKURLYTheme {
        ReviewScreen(modifier = Modifier, navController = rememberNavController())
    }
}