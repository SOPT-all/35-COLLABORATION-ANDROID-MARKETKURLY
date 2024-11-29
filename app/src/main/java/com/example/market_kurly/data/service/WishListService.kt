    package com.example.market_kurly.data.service

    import com.example.market_kurly.data.dto.base.BaseResponse
    import com.example.market_kurly.data.dto.response.ResponseWishListDto
    import retrofit2.http.GET
    import retrofit2.http.Header

    interface WishListService {

        companion object {
            const val API = "api"
            const val V1 = "v1"
            const val LIKES = "likes"
        }

        @GET("/$API/$V1/$LIKES")
        suspend fun getWishList(
            @Header("memberId") memberId: Number
        ) : BaseResponse<ResponseWishListDto>
    }