package com.ekyrizky.core.di

import com.ekyrizky.core.BuildConfig
import com.ekyrizky.core.data.remote.service.MarvelApi
import com.ekyrizky.core.utils.NetworkConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val apiInterceptor = Interceptor { chain ->
            val req = chain.request()
            val reqUrl = req.url

            val url = reqUrl.newBuilder()
                .addQueryParameter(NetworkConstant.API_KEY, BuildConfig.PUBLIC_API_KEY)
                .addQueryParameter(NetworkConstant.TIMESTAMP_KEY, NetworkConstant.timeStamp)
                .addQueryParameter(NetworkConstant.HASH_KEY, NetworkConstant.hash())
                .build()

            chain.proceed(req.newBuilder().url(url).build())
        }

        return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(apiInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkConstant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideMarvelApiService(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)
}