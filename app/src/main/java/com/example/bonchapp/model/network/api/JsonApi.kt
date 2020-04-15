package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.Event
import retrofit2.Call
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.model.pojo.RequestTutorsDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<List<Event>>

    //@FormUrlEncoded
    @POST("/api/timetable")
    fun getTimeTable(
        @Header("Accept") accept: String = "application/json",
        @Body body: RequestTimeTableDTO?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/tutors")
    fun getTutors(
        @Header("Accept") accept: String = "application/json",
        @Body body: RequestTutorsDTO?
    ): Call<ArrayList<SubjectDTO>>
}