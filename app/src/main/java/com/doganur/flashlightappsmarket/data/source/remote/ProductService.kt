package com.doganur.flashlightappsmarket.data.source.remote

import com.doganur.flashlightappsmarket.data.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("flashlights")
    fun getFlashlights(): Call<Flashlights>

    @GET("colorlights")
    fun getColoredLights(): Call<ColoredLights>

    @GET("sosalerts")
    fun getSosAlerts(): Call<SosAlerts>

}