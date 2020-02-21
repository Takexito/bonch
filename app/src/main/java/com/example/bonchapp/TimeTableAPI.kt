package com.example.bonchapp

import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface TimeTableAPI {
    @POST("timetable")
    fun requestTimeTable(
        @Body body: RequestDTO?
    ): Call<List<SubjectDTO>>
}