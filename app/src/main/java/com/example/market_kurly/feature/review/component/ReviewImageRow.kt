package com.example.market_kurly.feature.review.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray2
import com.example.market_kurly.ui.theme.MarketKurlyTheme
import com.example.market_kurly.ui.theme.White

@Composable
fun ReviewImageRow(
    modifier: Modifier = Modifier,
    imageUrls: List<String?>,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        val maxVisibleImages = 4

        val visibleImages = imageUrls.filterNotNull().take(maxVisibleImages)

        visibleImages.forEachIndexed { index, url ->
            val cornerShape =
                when {
                    visibleImages.size == 1 -> RoundedCornerShape(8.dp)
                    index == 0 -> RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                    index == visibleImages.lastIndex -> RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    else -> RoundedCornerShape(0.dp)
                }

            if (index == maxVisibleImages - 1 && imageUrls.size > maxVisibleImages) {
                Box(
                    modifier = Modifier
                        .size(81.dp)
                        .clip(cornerShape)
                        .background(Color.Gray.copy(alpha = 0.6f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(R.string.review_more_image),
                        style = MarketKurlyTheme.typography.captionR12,
                        color = White,
                    )
                }
            } else {
                Image(
                    painter = rememberAsyncImagePainter(model = url),
                    contentDescription = stringResource(R.string.review_image_row_single_image_description),
                    modifier = Modifier
                        .size(81.dp)
                        .clip(cornerShape)
                        .background(White),
                )
            }
        }
    }
}