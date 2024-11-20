package com.example.market_kurly.feature.goods

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.market_kurly.R
import com.example.market_kurly.feature.goods.component.KurlyGoodsInfoText
import com.example.market_kurly.feature.goods.component.KurlyGoodsMembershipToggleButton
import com.example.market_kurly.core.designsystem.component.KurlyProductsDetailBottomBar
import com.example.market_kurly.core.designsystem.component.KurlyProductsDetailTopBar
import com.example.market_kurly.core.util.KeyStorage.GOODS
import com.example.market_kurly.core.util.KeyStorage.REVIEW
import com.example.market_kurly.core.util.KeyStorage.WISHLIST
import com.example.market_kurly.core.util.price.calculateDiscountWithFloor
import com.example.market_kurly.core.util.price.toDecimalFormat
import com.example.market_kurly.domain.handler.MockFavoriteHandler
import com.example.market_kurly.domain.repositoryimpl.GoodsRepositoryImpl
import com.example.market_kurly.feature.goods.component.KurlyAlsoViewedColumnItem
import com.example.market_kurly.feature.goods.viewmodel.GoodsViewModel
import com.example.market_kurly.feature.goods.viewmodel.GoodsViewModelFactory
import com.example.market_kurly.ui.theme.Gray2
import com.example.market_kurly.ui.theme.Gray4
import com.example.market_kurly.ui.theme.Gray5
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.PrimaryColor400
import com.example.market_kurly.ui.theme.Red
import com.example.market_kurly.ui.theme.White

@Composable
fun GoodsScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val goodsRepository by lazy { GoodsRepositoryImpl() }
    val viewModelFactory by lazy { GoodsViewModelFactory(goodsRepository) }
    val viewModel : GoodsViewModel = viewModel(factory = viewModelFactory)

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            KurlyProductsDetailTopBar(
                goodsName = uiState.goodsDescriptions?.name.orEmpty(),
                selectedIndex = uiState.selectedTabIndex,
                navigateUp = {},
                navigateToGoodsDescription = {
                    navController.navigate(GOODS){
                        popUpTo(GOODS){ inclusive = true }
                        launchSingleTop = true
                    }
                },
                navigateGoodsReview = {
                    navController.navigate(REVIEW){
                        popUpTo(REVIEW){ inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        },
        bottomBar = {
            val mockHandler = remember { MockFavoriteHandler() }
            KurlyProductsDetailBottomBar(
                modifier = Modifier.background(White),
                favoriteHandler = mockHandler,
                navigateToWishList = { navController.navigate(WISHLIST) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Gray2),
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(uiState.goodsDescriptions?.image)
                        .build(),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = uiState.goodsDescriptions?.name.orEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.777f)
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 25.dp)
                ) {
                    Text(
                        text = uiState.goodsDescriptions?.deliverType.orEmpty(),
                        style = typography.bodyB14,
                        color = Gray5
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(60.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = uiState.goodsDescriptions?.name.orEmpty(),
                            style = typography.titleM18,
                            color = Gray7,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icn_goods_share),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "원산지: ${uiState.goodsDescriptions?.origin.orEmpty()}",
                        style = typography.titleM18,
                        color = Gray7,
                    )

                    Spacer(Modifier.height(14.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${uiState.goodsDescriptions?.price?.toDecimalFormat()}원",
                            textDecoration = TextDecoration.LineThrough,
                            style = typography.bodyR16,
                            color = Gray4
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icn_goods_info),
                            contentDescription = "",
                            tint = Gray4,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Spacer(Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${uiState.goodsDescriptions?.discount}%",
                            style = typography.titleB22,
                            color = Red
                        )
                        Text(
                            text = "${uiState.goodsDescriptions?.price?.calculateDiscountWithFloor(uiState.goodsDescriptions?.discount ?: 0)
                                ?.toDecimalFormat()}원",
                            style = typography.titleB22,
                            color = Gray7
                        )
                    }

                    Spacer(Modifier.height(3.dp))

                    KurlyGoodsMembershipToggleButton(
                        discount = uiState.goodsDescriptions?.membersDiscount ?: 0,
                        price = uiState.goodsDescriptions?.price ?: 0
                    )
                }
                Spacer(Modifier.height(1.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 17.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "배송",
                        infoContent = uiState.goodsDescriptions?.deliverType.orEmpty(),
                        infoSubContent = "23시 전 주문 시 수도권 / 충청 내일 아침 7시 전 도착\n(그 외 지역 아침 8시 전 도착)"
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "판매자",
                        infoContent = uiState.goodsDescriptions?.seller.orEmpty(),
                    )
                }
                Spacer(Modifier.height(8.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 21.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "다른 고객이 함께 본 상품",
                            style = typography.bodyB16,
                            color = Gray7
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "다음상품",
                                style = typography.bodyM16,
                                color = PrimaryColor400
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.icn_goods_nextgoods),
                                contentDescription = "",
                                tint = PrimaryColor400,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(7.dp))

                    uiState.alsoViewedList.forEach { item ->
                        KurlyAlsoViewedColumnItem(
                            image = item.image,
                            goodsName = item.goodsName,
                            discount = item.discount,
                            price = item.price
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            item {
                Text(
                    text = "상품정보",
                    style = typography.bodyB16,
                    color = Gray7,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(15.dp, 14.dp)
                )
            }

            items(uiState.goodsInfoList) { info ->
                if(info.second != "0") {
                    KurlyGoodsInfoText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                            .padding(15.dp, 5.dp),
                        infoTitle = info.first,
                        infoContent = info.second
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewGoodsScreen(){
    GoodsScreen(navController = NavHostController(LocalContext.current))
}