package com.example.bonchapp.model.network

import com.example.bonchapp.model.network.api.JsonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkService {
    val TABLE_API: JsonApi
    private val retrofit: Retrofit

    init{
        val okHttpClient = OkHttpClient.Builder().build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://delta-axis.me")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        TABLE_API = retrofit.create(
            JsonApi::class.java)
    }
}