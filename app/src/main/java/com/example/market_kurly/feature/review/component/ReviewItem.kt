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
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray3
import com.example.market_kurly.ui.theme.Gray4
import com.example.market_kurly.ui.theme.Gray5
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MarketKurlyTheme

@Composable
fun ReviewItem(
    userName: String,
    productName: String,
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
                modifier = Modifier.size(24.dp)
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
            imageUrls = listOf(
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81",
                "https://via.placeholder.com/81*81"
            ),
            modifier = Modifier.padding(top = 8.dp)
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
                        modifier = Modifier.size(16.dp)
                    )
                }
                repeat(5 - starCount) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Gray Star",
                        tint = Gray3,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}