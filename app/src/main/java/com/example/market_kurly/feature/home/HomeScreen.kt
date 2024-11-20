package com.example.market_kurly.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.example.market_kurly.R
import com.example.market_kurly.feature.home.component.AsyncImageFit
import com.example.market_kurly.feature.home.component.HomeBannerRow
import com.example.market_kurly.feature.home.component.HomeBottomNav
import com.example.market_kurly.feature.home.component.HomeProductRow
import com.example.market_kurly.feature.home.component.HomeProductTitle
import com.example.market_kurly.feature.home.component.HomeTagItemRow
import com.example.market_kurly.feature.home.component.HomeTopBar

private val bannerList = listOf(
    "https://velog.velcdn.com/images/roel_dev/post/c6270de0-ab33-4374-bacd-eaa541ecc521/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/3d117f6f-9d9e-4899-bcba-cb137ac19c39/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/c6270de0-ab33-4374-bacd-eaa541ecc521/image.png",
    "https://velog.velcdn.com/images/roel_dev/post/3d117f6f-9d9e-4899-bcba-cb137ac19c39/image.png",
)

private val tagMenuList = listOf(
    TagItem("최저가도전", R.drawable.ic_home_lowestprice),
    TagItem("멤버스특가", R.drawable.ic_home_members),
    TagItem("홈&리빙", R.drawable.ic_home_homeliving),
    TagItem("패션", R.drawable.ic_home_fashion),
    TagItem("선물추천", R.drawable.ic_home_present),
    TagItem("라이브커머스", R.drawable.ic_home_livecommerce),
    TagItem("컬리멤버스", R.drawable.ic_home_kurlymembers),
    TagItem("컬리큐레이터", R.drawable.ic_home_kurlycurator),
    TagItem("행운출첵", R.drawable.ic_home_luck),
    TagItem("오늘의타로", R.drawable.ic_home_todaytarot),
    TagItem("마이컬리맘", R.drawable.ic_home_mykurlyfarm),
    TagItem("쇼케이스", R.drawable.ic_home_showcase),
)

private val products = listOf(
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    ),
    ProductItem(
        "비비고 통새우만두 200g",
        "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/fbb7af4c-1d4f-4021-90b6-6208daf83756/img_home_product_dummy.png",
        6980,
        33,
        4630,
        1200,
    )

)

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (topBar, content, bottomNav) = createRefs()

        HomeTopBar(
            modifier = Modifier
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                }
        )

        Column(
            modifier = Modifier
                .constrainAs(content) {
                    top.linkTo(topBar.bottom)
                    bottom.linkTo(bottomNav.top)
                    height = Dimension.fillToConstraints
                }
                .verticalScroll(rememberScrollState())
        ) {
            HomeBannerRow(bannerList)
            Spacer(modifier = Modifier.height(8.dp))
            HomeTagItemRow(tagMenuList)
            Spacer(modifier = Modifier.height(31.dp))
            HomeProductTitle(
                "\uD83D\uDC51 껄디님을 위해 엄선했어요",
                "찜해 놓은 그 상품, 지금 빅세일로 저렴하게!",
               modifier = Modifier
                   .padding(start = 15.dp, end = 9.dp)
            ) {}
            Spacer(modifier = Modifier.height(17.dp))
            HomeProductRow(products)
            Spacer(modifier = Modifier.height(14.dp))
            AsyncImageFit(
                imageUrl = "https://prod-files-secure.s3.us-west-2.amazonaws.com/01c30015-16dc-4e14-8e54-35fb1a5705fe/826939ec-c3d6-4b17-9258-c7170db2bf29/IMG_0136_1.png",
                placeholder = R.mipmap.img_home_center_banner_dummy
            )
        }

        HomeBottomNav(
            modifier = Modifier
                .constrainAs(bottomNav) {
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

//        Text(
//            text = stringResource(R.string.home_screen),
//            style = MarketKurlyTheme.typography.titleB22,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//        )
//        Button(
//            onClick = { navController.navigate(GOODS) },
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(top = 16.dp)
//        ) {
//            Text(
//                text = stringResource(R.string.btn_go_to_goods),
//                style = MarketKurlyTheme.typography.bodyB14
//            )
//        }