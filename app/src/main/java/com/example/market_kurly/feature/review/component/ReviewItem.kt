package com.example.market_kurly.feature.review.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.Gray4
import com.example.market_kurly.ui.theme.Gray5
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MARKETKURLYTheme
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun ReviewItem(
    userName: String,
    productName: String,
    imageUrls: List<String>?,
    reviewText: String,
    reviewDate: String,
    starCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_review_advertisement),
                contentDescription = "Review Item advertisement icon",
                modifier = Modifier.size(37.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = userName,
                style = MarketKurlyTheme.typography.bodyM14,
                color = Gray7
            )
        }

        Text(
            text = productName,
            style = MarketKurlyTheme.typography.captionR12,
            color = Gray5,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        ReviewImageRow(
            modifier = Modifier.padding(top = 8.dp),
            imageUrls = imageUrls
        )

        Text(
            text = reviewText,
            style = MarketKurlyTheme.typography.bodyR14,
            color = Gray7,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = reviewDate,
                style = MarketKurlyTheme.typography.captionR12,
                color = Gray4
            )

            Row {
                repeat(starCount) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Yellow Star",
                        tint = Color(0xFFFFD951),
                        modifier = modifier.size(16.dp)
                    )
                }
                repeat(5 - starCount) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Gray Star",
                        tint = Gray3,
                        modifier = modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewItemPreview() {
    MARKETKURLYTheme {
        ReviewItem(
            userName = "신**",
            productName = "시나노골드 (금사과) 1.3kg (5~7입)",
            imageUrls = null,
            reviewText = "요즘 사과 품종별로 비교해보는 재미에 빠졌어요. 감홍의 맛을 가장 좋아하긴 하는데 맛 비교 자체가 너무 즐거워요.\n" +
                    "시나노골드는 처음 먹어보는데 황금사과라는 이름에 걸맞게 정말 금색이에요 ㅎㅎ\n" +
                    "일단은 그냥 온전히 껍질째 먹었어요. 확실히 연한 느낌이에요. 껍질도 과육도요.\n" +
                    "감홍이 깊은 단맛과 향이라면 이거는 싱그러운 단맛과 향이에요.",
            reviewDate = "2022.11.15",
            starCount = 4,
            modifier = Modifier
        )
    }
}