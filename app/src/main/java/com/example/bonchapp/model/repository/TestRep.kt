package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TestRep {
    fun getGroups(): LiveData<ArrayList<String>> {
        val data = MutableLiveData<ArrayList<String>>()
        NetworkService
            .TABLE_API
            .getGroups()
            .enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(call: Call<ArrayList<String>>, resp: Response<ArrayList<String>>) {
                    Log.d("LoL", "Good")
                    data.value = resp.body() ?: arrayListOf("Error!") //TODO: create adapter to handle error response
                }

                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("LoL", t.localizedMessage ?: "Error!")

                }
            })
        return data
    }

}