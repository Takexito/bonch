package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.Auth
import com.example.bonchapp.model.pojo.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    @POST("/api/login")
    fun getToken(
        @Header("Accept") accept: String = "application/json",
        @Body body: Auth?
    ): Call<Token>
}