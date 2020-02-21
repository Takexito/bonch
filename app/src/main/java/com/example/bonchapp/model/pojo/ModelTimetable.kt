package com.example.bonchapp.model.pojo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.MainContract
import com.example.bonchapp.model.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelTimetable() : MainContract.Model {

    override fun loadTimetable(day: String): LiveData<ArrayList<String>> {

        /*val timetableService = NetworkService.TABLE_API

        val timetable = MutableLiveData<List<SubjectDTO>>().apply {

            //val response = timetableService.requestTimeTable(RequestDTO(0, Info(), Date()))
            val response = timetableService.getGroups()
            lateinit var subjects: List<SubjectDTO>

            /*CoroutineScope(Dispatchers.Main).launch {

                try {
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            subjects = response.body()!!
                        }
                    }
                } catch (err: Exception) {
                    Log.e("Retrofit", "${err.printStackTrace()}")
                }
            }*/

            //response.enqueue(object : Callback<List<SubjectDTO>> {
            response.enqueue(object : Callback<ArrayList<String>> {

                //override fun onFailure(call: Call<List<SubjectDTO>>, t: Throwable) {
                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("retrofit", "call failed")
                }

                //override fun onResponse(call: Call<List<SubjectDTO>>, response: Response<List<SubjectDTO>>) {
                override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                    Log.d("retrofit", "call super")
                }
            })
        }*/

        val data = MutableLiveData<ArrayList<String>>()
        NetworkService
            .TABLE_API
            .getGroups()
            .enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(
                    call: Call<ArrayList<String>>,
                    resp: Response<ArrayList<String>>
                ) {
                    Log.d("LoL", "Good")
                    data.value = resp.body()
                        ?: arrayListOf("Error!")
                }

                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("LoL", t.localizedMessage ?: "Error!")

                }
            })
        return data
    }

}