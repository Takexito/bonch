package com.example.bonchapp.data.api

import com.example.bonchapp.domain.entities.*
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.router.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @GET("/api/timetable/group")
    //fun getGroups(@Header("Authorization") token: String = "Token ${User.token.value}"
    fun getGroups(@Header("Authorization") token: String = "Token cec257ea71d8b96aac5b54bdf5d60667616d357e"
    ): Call<ArrayList<ArrayList<String>>>

//    @GET("/api/timetable/group")
//    fun getEvents(@Header("Authorization") token: String = "Token ${User.token.value}"
//    ): Call<List<Event>>

    @GET("/api/timetable/group")
    fun getNews(@Header("Authorization") token: String = "Token ${User.token.value}"
    ): Call<ArrayList<ArrayList<String>>>

    //@FormUrlEncoded
    @POST("/api/timetable")
    fun getTimeTable(
        //@Header("Accept") accept: String = "application/json",
        //@Header("Authorization") token: String = "Token ${User.token.value}",
        @Header("Authorization") token: String = "Token cec257ea71d8b96aac5b54bdf5d60667616d357e",
        @Body body: RequestTimeTable?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/timetable/tutor/long")
    fun getTutors(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token cec257ea71d8b96aac5b54bdf5d60667616d357e"
    ): Call<ArrayList<String>>

    @POST("/api/login")
    fun getToken(
        @Header("Accept") accept: String = "application/json",
        @Body body: Auth?
    ): Call<Token>

}
