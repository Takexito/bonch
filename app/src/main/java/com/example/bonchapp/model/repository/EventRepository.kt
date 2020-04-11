package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventRepository : IEventRepository {

    private lateinit var liveData: LiveData<ArrayList<String>>

    override fun getAllEvents(liveData: MutableLiveData<ArrayList<String>>) {
        NetworkService
            .TABLE_API
            .getGroups()
            .enqueue(object : Callback<ArrayList<String>> {
                override fun onResponse(
                    call: Call<ArrayList<String>>,
                    resp: Response<ArrayList<String>>
                ) {
                    Log.d("Test", "Good")
                    liveData.value = resp.body() ?: arrayListOf(
                        "Error!",
                        "LOL",
                        "statr"
                    ) //TODO: create adapter to handle error response

                }

                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.d("Test", t.localizedMessage ?: "Error!")

                }
            })
    }

    override fun getFavoriteEvent(liveData: MutableLiveData<ArrayList<String>>) {

    }

    override fun addFavoriteEvent(event: String) {
        liveData.value?.add(event)
        Log.d("Like", "add $event")
    }

    override fun getMyEvents(liveData: MutableLiveData<ArrayList<String>>) {

    }
}