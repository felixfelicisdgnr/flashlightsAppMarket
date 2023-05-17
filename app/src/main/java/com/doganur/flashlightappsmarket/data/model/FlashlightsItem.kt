package com.doganur.flashlightappsmarket.data.model

data class FlashlightsItem(
    val category: String?,
    val developerAddress: String?,
    val developerEmail: String?,
    val developerName: String?,
    val downloads: String?,
    val iconUrl: String?,
    val name: String?,
    val packageName: String?,
    val price: String?,
    val publishDate: PublishDate?,
    val ratingCount: Int?,
    val ratingValue: Double?,
    val version: String?
)