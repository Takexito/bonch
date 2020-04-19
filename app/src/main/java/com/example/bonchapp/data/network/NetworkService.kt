package com.example.bonchapp.data.network

import com.example.bonchapp.domain.entities.Event
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("/api/groups")
    fun getGroups(): Call<List<Event>>
}