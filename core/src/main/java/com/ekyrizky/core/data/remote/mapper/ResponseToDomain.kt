package com.ekyrizky.core.data.remote.mapper

import com.ekyrizky.core.data.remote.model.BaseResponse
import com.ekyrizky.core.data.remote.model.HeroResponse
import com.ekyrizky.core.domain.model.Hero
import com.ekyrizky.core.domain.model.Heroes

internal fun BaseResponse<HeroResponse>.toDomain(): Heroes {
    return Heroes(
        data.offset,
        data.limit,
        data.total,
        data.count,
        data.results.map { hero -> hero.toDomain() }
    )
}

internal fun HeroResponse.toDomain(): Hero {
    return Hero(
        id ?: 0,
        name ?: "",
        description ?: "",
        date ?: "",
        image?.path ?: ""
    )
}