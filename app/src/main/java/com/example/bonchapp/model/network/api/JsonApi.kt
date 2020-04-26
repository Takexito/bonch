package com.example.bonchapp.model.network.api

import retrofit2.Call
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.model.pojo.RequestTutorsDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<ArrayList<String>>

    //@FormUrlEncoded
    @POST("/api/timetable/")
    fun getTimeTable(

        //@Header("Accept") accept: String = "application/json",
        @Header("Authorization") token:String = "Token 250332a63214da763d276a20c0ad4b586312db2b",
        @Body body: RequestTimeTableDTO?
    ): Call<ArrayList<SubjectDTO>>

    @POST("/api/tutors")
    fun getTutors(
        @Header("Accept") accept: String = "application/json",
        @Body body: RequestTutorsDTO?
    ): Call<ArrayList<String>>
}