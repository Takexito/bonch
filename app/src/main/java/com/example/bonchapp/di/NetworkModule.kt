package com.example.bonchapp.di

import com.example.bonchapp.data.network.NetworkService
import com.example.bonchapp.domain.util.Consts
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideNetworkService(): NetworkService {
        val okHttpClient = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl(Consts.HOST)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}