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
        @Body body:RequestDTO?
    //@Field("range") range: Int = 0
        //@Field("info", encoded = false) info: Array<String> = arrayOf("group", "ИКТ-802"),
        //@Field("date") date: Array<String> = arrayOf("2020-02-12", "2020-02-12")
        //@Field("type") type: String = "group",
        //@Field("text") text: String = URLEncoder.encode("ИКТ-802", StandardCharsets.UTF_8.toString()),
        //@Field("from") from: String = "2020-02-12",
        //@Field("to") to: String = "2020-02-12"
    ): Call<ArrayList<SubjectDTO>>
}