package com.doganur.flashlightappsmarket.data.model


import com.google.gson.annotations.SerializedName

data class PublishDateX(
    @SerializedName("day")
    val day: Int?,
    @SerializedName("month")
    val month: Int?,
    @SerializedName("year")
    val year: Int?
)