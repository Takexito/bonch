package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.Event
import retrofit2.Call
import retrofit2.http.GET


interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<List<Event>>

}