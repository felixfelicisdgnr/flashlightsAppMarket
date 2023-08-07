package com.doganur.flashlightappsmarket.common

import com.doganur.flashlightappsmarket.data.source.remote.ProductService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val modifiedRequest = originalRequest.newBuilder()
                .header("JsonStub-User-Key", "f5e0861a-b53d-4b80-9c28-2233780c3d5d")
                .build()
            chain.proceed(modifiedRequest)
        }
        .build()

    val api: ProductService by lazy {

        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://m104e.wiremockapi.cloud/v1/")
            .client(okHttpClient)
            .build()
            .create(ProductService::class.java)
    }
}