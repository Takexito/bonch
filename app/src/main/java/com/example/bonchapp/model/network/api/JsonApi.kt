package com.example.bonchapp.model.network.api

import com.example.bonchapp.model.pojo.*
import retrofit2.Call
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.http.*


interface JsonApi {
    @GET("/api/groups")
    fun getGroups(): Call<ArrayList<String>>

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



    @GET("/api/user/account")
    fun getUserInfo(
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<AccountDTO>

    @GET("/api/user/debt")
    fun getDebt(
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<ArrayList<DebtDTO>>

    @GET("/api/user/history")
    fun getHistoryElectives(
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<ArrayList<ElectiveDTO>>

    @GET("/api/user/mark")
    fun getMark(
        @Header("Authorization") token: String = "Token e06656026b80699b5d286f482518f0791522b42b"
    ): Call<ArrayList<MarkDTO>>
}