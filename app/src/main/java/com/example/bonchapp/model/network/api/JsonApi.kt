package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.GroupDTO
import retrofit2.Call
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.model.pojo.RequestTutorsDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {

    @GET("/api/timetable/group")
    fun getGroups(@Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<ArrayList<ArrayList<String>>>

    //@FormUrlEncoded
    @POST("/api/timetable/")
    fun getTimeTable(

        //@Header("Accept") accept: String = "application/json",
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b",
        @Body body: RequestTimeTableDTO?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/timetable/tutor/long")
    fun getTutors(
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<ArrayList<String>>
}