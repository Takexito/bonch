package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TestRep {
    fun getGroups(liveData: MutableLiveData<ArrayList<String>>) {
        NetworkService
            .TABLE_API
            .getGroups()
            .enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(
                    call: Call<ArrayList<String>>,
                    resp: Response<ArrayList<String>>
                ){
                    Log.d("Test", "Good")
                    liveData.value = resp.body() ?: arrayListOf("Error!", "LOL", "statr") //TODO: create adapter to handle error response

                }

                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })
    }

}