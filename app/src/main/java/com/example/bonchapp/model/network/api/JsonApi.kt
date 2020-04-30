package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.GroupDTO
import com.example.bonchapp.model.pojo.Auth
import retrofit2.Call
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.model.pojo.RequestTutorsDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {

    @GET("/api/timetable/group")
    fun getGroups(@Header("Authorization") token: String = "Token 250332a63214da763d276a20c0ad4b586312db2b"
    ): Call<ArrayList<ArrayList<String>>>

    //@FormUrlEncoded
    @POST("/api/timetable/")
    fun getTimeTable(

        //@Header("Accept") accept: String = "application/json",
        @Header("Authorization") token: String = "Token 250332a63214da763d276a20c0ad4b586312db2b",
        @Body body: RequestTimeTableDTO?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/timetable/tutor/long")
    fun getTutors(
        @Header("Authorization") token: String = "Token 250332a63214da763d276a20c0ad4b586312db2b"
    ): Call<ArrayList<String>>

}