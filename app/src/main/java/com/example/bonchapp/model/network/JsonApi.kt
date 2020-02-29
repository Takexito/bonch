package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.Date
import com.example.bonchapp.model.pojo.Info
import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<ArrayList<String>>

    //@FormUrlEncoded
    @POST("/api/timetable")
    fun requestTimeTable(
        @Header("Accept") accept: String = "application/json",
        @Body body: RequestDTO?
    ): Call<ArrayList<SubjectDTO>>
}