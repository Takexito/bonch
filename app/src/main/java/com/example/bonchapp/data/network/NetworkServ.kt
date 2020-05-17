package com.example.bonchapp.data.network

import com.example.bonchapp.data.api.NetworkService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkServ {
    val TABLE_API: NetworkService
    private val retrofit: Retrofit

    init{
        val okHttpClient = OkHttpClient.Builder().build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://delta-axis.me")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        TABLE_API = retrofit.create(
            NetworkService::class.java)
    }
}