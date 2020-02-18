package com.example.bonchapp.model.network

import com.example.bonchapp.model.network.api.JsonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkService {
    val TABLE_API: JsonApi
    private val mRetrofit: Retrofit

    init{
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl("http://165.22.199.70/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        TABLE_API = mRetrofit.create(
            JsonApi::class.java)
    }
}