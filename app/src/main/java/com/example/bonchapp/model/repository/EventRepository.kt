package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventRepository : IEventRepository {

    val allEventLiveData = MutableLiveData<ArrayList<String>>()
    val favoriteEventLiveData = MutableLiveData<ArrayList<String>>()
    val myEventLiveData = MutableLiveData<ArrayList<String>>()
    var isRev = false

    override fun getAllEvents():MutableLiveData<ArrayList<String>> {
        return getAllEventsRetrofit()
    }

    private fun getAllEventsRetrofit(): MutableLiveData<ArrayList<String>>{
        Log.d("EventRepository", "request")
        NetworkService.TABLE_API.getGroups().enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(call: Call<ArrayList<String>>, resp: Response<ArrayList<String>>) {
                Log.d("EventRepository", "Good")
                if(isRev) allEventLiveData.value = resp.body() //TODO: handle error response
                else allEventLiveData.value = resp.body()?.reversed() as ArrayList<String>
                isRev = !isRev
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                Log.d("EventRepository", t.localizedMessage ?: "Error!")
            }
        })
        return allEventLiveData
    }

    override fun getFavoriteEvent(): MutableLiveData<ArrayList<String>> {
        return favoriteEventLiveData
    }

    override fun addFavoriteEvent(event: String) {
        Log.d("Like", "add $event")
    }

    override fun getMyEvents(): MutableLiveData<ArrayList<String>>{
        return myEventLiveData
    }
}