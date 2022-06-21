package com.ekyrizky.core.data.remote.model

import com.squareup.moshi.Json

data class BaseResponse<T>(
    @Json(name = "code")
    val code: Int,
    @Json(name = "status")
    val status: String,
    @Json(name = "data")
    val data: HeroesResponse<T>
)