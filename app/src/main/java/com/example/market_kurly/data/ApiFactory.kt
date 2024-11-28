package com.example.market_kurly.data

import com.example.market_kurly.BuildConfig
import com.example.market_kurly.data.service.ExampleService
import com.example.market_kurly.data.service.GoodsService
import com.example.market_kurly.data.service.LikeService
import com.example.market_kurly.data.service.ReviewService
import com.example.market_kurly.data.service.WishListService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL: String = BuildConfig.BASE_URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val exampleService = ApiFactory.create<ExampleService>()
    val goodsService = ApiFactory.create<GoodsService>()
    val likeService = ApiFactory.create<LikeService>()
    val reviewService = ApiFactory.create<ReviewService>()
    val wishListService = ApiFactory.create<WishListService>()
}
