package com.ekyrizky.core.utils

import com.ekyrizky.core.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object NetworkConstant {
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val API_KEY = "apikey"
    const val TIMESTAMP_KEY = "ts"
    const val HASH_KEY = "hash"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String {
        val input = "$timeStamp${BuildConfig.PRIVATE_API_KEY}${BuildConfig.PUBLIC_API_KEY}"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}