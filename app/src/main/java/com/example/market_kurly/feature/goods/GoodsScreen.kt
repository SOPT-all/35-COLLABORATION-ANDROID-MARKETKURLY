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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.market_kurly.R
import com.example.market_kurly.feature.goods.component.KurlyGoodsInfoText
import com.example.market_kurly.feature.goods.component.KurlyGoodsMembershipToggleButton
import com.example.market_kurly.core.designsystem.component.KurlyProductsDetailBottomBar
import com.example.market_kurly.core.designsystem.component.KurlyProductsDetailTopBar
import com.example.market_kurly.core.dummymodel.AlsoViewedItem
import com.example.market_kurly.core.util.KeyStorage.ALL_TABS
import com.example.market_kurly.core.util.KeyStorage.GOODS
import com.example.market_kurly.core.util.KeyStorage.GOODS_DESCRIPTION
import com.example.market_kurly.core.util.KeyStorage.REVIEW
import com.example.market_kurly.core.util.KeyStorage.WISHLIST
import com.example.market_kurly.core.util.price.calculateDiscountWithFloor
import com.example.market_kurly.core.util.price.toDecimalFormat
import com.example.market_kurly.domain.handler.MockFavoriteHandler
import com.example.market_kurly.feature.goods.component.KurlyAlsoViewedColumnItem
import com.example.market_kurly.ui.theme.Gray2
import com.example.market_kurly.ui.theme.Gray4
import com.example.market_kurly.ui.theme.Gray5
import com.example.market_kurly.ui.theme.Gray7
import com.example.market_kurly.ui.theme.MarketKurlyTheme.typography
import com.example.market_kurly.ui.theme.Red
import com.example.market_kurly.ui.theme.White

@Composable
fun GoodsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val price = 14900
    val discount = 13
    val name = "아삭하고 달콤한 황금사과1.3kg (5~7입)[품종:시나노골드]"
    val deliveryType = "샛별배송"
    val origin = "국산"
    val memberDiscount = 26
    val dummyAlsoViewedList = listOf(
        AlsoViewedItem("[KF365] 유명산지 고당도사과 1.5kg (5~6입)", 16, 19900),
        AlsoViewedItem("고랭지 햇사과 1.3kg (4~6입)", 13, 14900),
        AlsoViewedItem("감홍 사과 1.3kg (4~6입)", 25, 19900),
        AlsoViewedItem("세척 사과 1.4kg (7입)", 16, 14900)
    )

    Scaffold(
        topBar = {
            KurlyProductsDetailTopBar(
                goodsName = name,
                selectedIndex = ALL_TABS.indexOf(GOODS_DESCRIPTION),
                navigateUp = {},
                navigateToGoodsDescription = { navController.navigate(GOODS) },
                navigateGoodsReview = { navController.navigate(REVIEW)}
            )
        },
        bottomBar = {
            val mockHandler = remember { MockFavoriteHandler() } //TODO: api 연결 전 Test용 Mock 데이터 사용, 추후 아래 코드로 변경
            KurlyProductsDetailBottomBar(
                modifier = Modifier
                    .background(White),
                favoriteHandler = mockHandler,
                navigateToWishList = { navController.navigate(WISHLIST) }
            )
            /*TODO: API 연동 시 이런 식으로 favoriteHandler에 viewModel을 주면 됩니다. 해당 viewModel에서 FavoriteHandler 구현하도록 해주세요
            KurlyProductsDetailBottomBar(
                modifier = Modifier
                    .background(White),
                favoriteHandler = viewModel
            )
            */
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .background(Gray2)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_goods_thumbnail),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.777f)
                )
                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 25.dp)
                ) {
                    Text(
                        text = deliveryType,
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
                            text = name,
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
                        text = "원산지: ${origin}",
                        style = typography.titleM18,
                        color = Gray7,
                    )

                    Spacer(Modifier.height(14.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${price.toDecimalFormat()}원",
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
                            text = "${discount}%",
                            style = typography.titleB22,
                            color = Red
                        )
                        Text(
                            text = "${(price.calculateDiscountWithFloor(discount).toDecimalFormat())}원",
                            style = typography.titleB22,
                            color = Gray7
                        )
                    }

                    Spacer(Modifier.height(3.dp))

                    KurlyGoodsMembershipToggleButton(
                        discount = memberDiscount,
                        price = price
                    )
                }

                Spacer(modifier = Modifier.height(1.dp))

                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 17.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "배송",
                        infoContent = deliveryType,
                        infoSubContent = "23시 전 주문 시 수도권 / 충청 내일 아침 7시 전 도착\n(그 외 지역 아침 8시 전 도착)"
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "판매자",
                        infoContent = "컬리",
                    )
                }

                Spacer(modifier = Modifier.height(7.dp))

                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 21.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    dummyAlsoViewedList.forEach { item ->
                        KurlyAlsoViewedColumnItem(
                            goodsName = item.goodsName,
                            discount = item.discount,
                            price = item.price
                        )
                    }
                }

                Spacer(modifier = Modifier.height(7.dp))

                Column(
                    modifier = Modifier
                        .background(White)
                        .padding(15.dp, 25.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "상품정보",
                        style = typography.bodyB16,
                        color = Gray7
                    )
                    Spacer(Modifier.height(14.dp))
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "포장타입",
                        infoContent = "냉장(종이포장)",
                        infoSubContent = "택배배송은 에코 포장이 스티로폼으로 대체됩니다."
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "판매단위",
                        infoContent = "1봉",
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "중량/용량",
                        infoContent = "1.3Kg 내외",
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "소비기한(또는 유통기한)정보",
                        infoContent = "농산물로 별도의 소비기한은 없으나 가급적 빠르게 드시기 바랍니다.",
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "당도",
                        infoContent = "13.5 Brix 이상",
                    )
                    KurlyGoodsInfoText(
                        modifier = Modifier.fillMaxWidth(),
                        infoTitle = "안내사항",
                        infoContent = "식품 특성상 중량은 3% 내외의 차이가 발생할 수 있습니다.\n" +
                                "신선식품 특성상 원물마다 크기 및 형태가 일정하지 않을 수 있습니다.",
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