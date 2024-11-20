package com.example.market_kurly.feature.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.MARKETKURLYTheme

@Composable
fun AsyncImageFit (
    imageUrl: String,
    @DrawableRes placeholder: Int,
) {
    val context = LocalContext.current
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth(),
        model = ImageRequest.Builder(context).data(imageUrl)
            .placeholder(placeholder)
            .error(placeholder)
            .build(),
        contentDescription = "Home Banner",
        placeholder = painterResource(id = placeholder),
        onError = {
            // 여기서 에러 잡으면 됩니다.
        },
        contentScale = ContentScale.FillWidth
    )
}

@Preview
@Composable
private fun HomeBannerPreview() {
    MARKETKURLYTheme {
        AsyncImageFit(
            imageUrl = "https://velog.velcdn.com/images/roel_dev/post/7b723d45-14a7-45a9-b489-f6cbc9c2035e/image.png",
            placeholder = R.mipmap.img_home_banner_dummy
        )
    }
}