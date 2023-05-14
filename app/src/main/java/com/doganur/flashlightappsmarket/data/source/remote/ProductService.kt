package com.doganur.flashlightappsmarket.data.source.remote

import com.doganur.flashlightappsmarket.data.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
/*
@POST("delete_from_bag.php")
    @Headers("Authorization: YourToken")
    suspend fun deleteFromBag(@Field("id") id: Int): CRUDResponse


 */
    @GET("flashlights")
    fun getFlashlights():Call<Flashlights>

    @GET("colorlights")
    fun getColoredLights():Call<ColoredLights>

    @GET("sosalerts")
    fun getSosAlerts():Call<SosAlerts>


}