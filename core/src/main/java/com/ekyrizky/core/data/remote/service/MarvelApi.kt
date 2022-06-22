package com.ekyrizky.core.data.remote.service

import com.ekyrizky.core.data.remote.model.BaseResponse
import com.ekyrizky.core.data.remote.model.HeroResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getHeroes(
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): BaseResponse<HeroResponse>
}