package com.example.bonchapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.presentation.MainContract
import com.example.bonchapp.data.network.NetworkServ
import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.entities.RequestTimeTableDTO
import com.example.bonchapp.pojo.SubjectDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelTimetable() : MainContract.ITimeTableModel {

    override fun loadTimetable(body: RequestTimeTable): LiveData<ArrayList<SubjectDTO>> {

        val data = MutableLiveData<ArrayList<SubjectDTO>>()
        NetworkServ
            .TABLE_API
            .getTimeTable(body = body)
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

    override fun getGroups(): LiveData<ArrayList<ArrayList<String>>>  {

        val data = MutableLiveData<ArrayList<ArrayList<String>>>()

        NetworkServ
            .TABLE_API
            .getGroups()
            .enqueue(object : Callback<ArrayList<ArrayList<String>>> {
                override fun onResponse(
                    call: Call<ArrayList<ArrayList<String>>>,
                    resp: Response<ArrayList<ArrayList<String>>>
                ){
                    Log.d("Test", "Good")
                    data.value = resp.body()

                }

                override fun onFailure(call: Call<ArrayList<ArrayList<String>>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }

    override fun getTutors(): LiveData<ArrayList<String>>  {

        val data = MutableLiveData<ArrayList<String>>()

        NetworkServ
            .TABLE_API
            .getTutors()
            .enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(
                    call: Call<ArrayList<String>>,
                    resp: Response<ArrayList<String>>
                ){
                    Log.d("Test", "Good")
                    data.value = resp.body() ?: arrayListOf("Error!", "LOL", "statr")

                }

                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })

        return data
    }

    fun loadSavedNameGroup(name:String){

    }
}