package com.ekyrizky.core.data.remote.model

import com.squareup.moshi.Json

data class HeroResponse(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "modified")
    val date: String?,
    @Json(name = "thumbnail")
    val image: ThumbnailResponse?,
)