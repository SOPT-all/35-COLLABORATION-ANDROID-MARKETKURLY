package com.example.market_kurly.feature.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.market_kurly.R

@Composable
fun AsyncImageFillWidth (
    imageUrl: String?,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    AsyncImage(
        modifier = modifier
            .fillMaxWidth(),
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .build(),
        contentDescription = stringResource(id = R.string.home_banner_description),
        contentScale = ContentScale.FillWidth
    )
}