package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<ArrayList<String>>

    @POST("/api/timetable")
    fun requestTimeTable(
        @Body body: RequestDTO?
    ): Call<ArrayList<SubjectDTO>>
}