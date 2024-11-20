package com.example.market_kurly.domain.repositoryimpl

import com.example.market_kurly.core.dummymodel.AlsoViewedData
import com.example.market_kurly.core.dummymodel.GoodsDetailData
import com.example.market_kurly.core.dummymodel.GoodsUiData
import com.example.market_kurly.core.dummymodel.asGoodsUiData
import com.example.market_kurly.domain.repository.GoodsRepository

class GoodsRepositoryImpl(

) : GoodsRepository {
    override fun getDummyAlsoViewedList(): List<AlsoViewedData> =
        listOf(
            AlsoViewedData("https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/59526651-9c34-4a39-9cd0-e30669a9ec4f.jpg","[KF365] 유명산지 고당도사과 1.5kg (5~6입)", 16, 19900),
            AlsoViewedData("https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/d79e3f0a-2739-4d54-a5b3-3dbd1d5b4388.jpeg","고랭지 햇사과 1.3kg (4~6입)", 13, 14900),
            AlsoViewedData("https://img-cf.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/shop/data/goods/160342712083l0.jpg","감홍 사과 1.3kg (4~6입)", 25, 19900),
            AlsoViewedData("https://product-image.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/product/image/30b30de4-14f7-438a-844d-604b5a2acde9.jpg","세척 사과 1.4kg (7입)", 16, 14900)
        )

    override fun getDummyGoodsDetail(): GoodsUiData =
        GoodsDetailData(
            allergy = "0",
            brix = "13.5 Brix 이상",
            category = "과일, 견과, 쌀",
            deliverType = "샛별배송",
            discount = 13,
            expiration = "농산물로 별도의 소비기한은 없으나 가급적 빠르게 드시기 바랍니다.",
            image = "https://img-cf.kurly.com/hdims/resize/%5E%3E720x%3E936/cropcenter/720x936/quality/85/src/shop/data/goods/1538466010000_l.jpg",
            livestock = "0",
            membersDiscount = 26,
            name = "아삭하고 달콤한 황금사과1.3kg (5~7입)[품종:시나노골드]",
            notification = "식품 특성상 중량은 3% 내외의 차이가 발생할 수 있습니다.\n신선식품 특성상 원물마다 크기 및 형태가 일정하지 않을 수 있습니다.",
            origin = "국산",
            packagingType = "냉장 (종이포장)",
            price = 14900,
            seller = "컬리",
            sellingUnit = "1봉",
            view = 156327,
            weight = "1.3kg 내외",
            isFavorite = true
        ).asGoodsUiData()
}