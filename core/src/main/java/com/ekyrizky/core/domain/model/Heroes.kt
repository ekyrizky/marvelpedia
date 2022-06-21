package com.ekyrizky.core.domain.model

data class Heroes(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Hero>,
)