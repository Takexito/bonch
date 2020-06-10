package com.example.bonchapp.data.api

import com.example.bonchapp.domain.entities.*
import com.example.bonchapp.router.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @GET("/api/timetable/group")
    //fun getGroups(@Header("Authorization") token: String = "Token ${User.token.value}"
    fun getGroups(@Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<ArrayList<ArrayList<String>>>

    @GET("/api/timetable/group")
    fun getNews(@Header("Authorization") token: String = "Token ${User.token.value}"
    ): Call<ArrayList<ArrayList<String>>>

    @POST("/api/timetable")
    fun getTimeTable(
        //@Header("Authorization") token: String = "Token ${User.token.value}",
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d",
        @Body body: RequestTimeTable?
    ): Call<ArrayList<SubjectDTO>>

    @GET("/api/timetable/tutor/long")
    fun getTutors(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<ArrayList<String>>

    @POST("/api/login")
    fun getToken(
        @Header("Accept") accept: String = "application/json",
        @Body body: Auth?
    ): Call<Token>




    @GET("/api/user/account")
    fun getUserInfo(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<AccountDTO>

    @GET("/api/user/debt")
    fun getDebt(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<ArrayList<DebtDTO>>

    @GET("/api/user/history")
    fun getHistoryElectives(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<ArrayList<ElectiveDTO>>

    @GET("/api/user/mark")
    fun getMark(
        //@Header("Authorization") token: String = "Token ${User.token.value}"
        @Header("Authorization") token: String = "Token 2862f0edde71b45d44d897c88ba4516bccdc172d"
    ): Call<ArrayList<MarkDTO>>
}
