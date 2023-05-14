package com.doganur.flashlightappsmarket.data.model


import com.google.gson.annotations.SerializedName

data class ColoredLightsItem(
    @SerializedName("category")
    val category: String?,

    @SerializedName("developerAddress")
    val developerAddress: String?,

    @SerializedName("developerEmail")
    val developerEmail: String?,

    @SerializedName("developerName")
    val developerName: String?,

    @SerializedName("downloads")
    val downloads: String?,

    @SerializedName("iconUrl")
    val iconUrl: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("packageName")
    val packageName: String?,

    @SerializedName("price")
    val price: String?,

    @SerializedName("publishDate")
    val publishDate: PublishDateX?,

    @SerializedName("ratingCount")
    val ratingCount: Int?,

    @SerializedName("ratingValue")
    val ratingValue: Double?,

    @SerializedName("version")
    val version: String?
)