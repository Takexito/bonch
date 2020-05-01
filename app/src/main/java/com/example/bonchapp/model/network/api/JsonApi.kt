package com.example.bonchapp.model.network.api

import com.example.bonchapp.coordinator.User
import com.example.bonchapp.model.pojo.*
import retrofit2.Call
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {

    @GET("/api/timetable/group")
    fun getGroups(@Header("Authorization") token: String = "Token ${User.token.value}"
    ): Call<ArrayList<ArrayList<String>>>

    @GET("/api/timetable/group")
    fun getNews(@Header("Authorization") token: String = "Token ${User.token.value}"
    ): Call<ArrayList<ArrayList<String>>>

    //@FormUrlEncoded
    @POST("/api/timetable/")
    fun getTimeTable(
        //@Header("Accept") accept: String = "application/json",
        @Header("Authorization") token: String = "Token ${User.token.value}",
        @Body body: RequestTimeTableDTO?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/timetable/tutor/long")
    fun getTutors(
        @Header("Authorization") token: String = "Token ${User.token.value}"
    ): Call<ArrayList<String>>

    @POST("/api/login")
    fun getToken(
        @Header("Accept") accept: String = "application/json",
        @Body body: Auth?
    ): Call<Token>

}