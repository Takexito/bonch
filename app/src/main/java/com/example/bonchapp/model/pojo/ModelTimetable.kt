package com.example.bonchapp.model.pojo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.MainContract
import com.example.bonchapp.model.network.NetworkService
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class ModelTimetable() : MainContract.Model {

    override fun loadTimetable(body:RequestDTO): LiveData<ArrayList<SubjectDTO>> {

        val data = MutableLiveData<ArrayList<SubjectDTO>>()
        NetworkService
            .TABLE_API
            .requestTimeTable(body = body)
            .enqueue(object : Callback<ArrayList<SubjectDTO>> {
                override fun onResponse(
                    call: Call<ArrayList<SubjectDTO>>,
                    resp: Response<ArrayList<SubjectDTO>>
                ) {
                    Log.d("LoL", "Good")
                    data.value = resp.body()
                        ?: arrayListOf(SubjectDTO())
                }

                override fun onFailure(call: Call<ArrayList<SubjectDTO>>, t: Throwable) {
                    Log.d("LoL", t.localizedMessage ?: "Error!")

                }
            })
        return data
    }

}