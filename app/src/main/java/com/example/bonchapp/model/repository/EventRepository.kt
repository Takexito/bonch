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

    override fun getAllEvents():MutableLiveData<ArrayList<String>> {
        return getAllEventsRetrofit()
    }

    private fun getAllEventsRetrofit(): MutableLiveData<ArrayList<String>>{
        Log.d("EventRepository", "request")
        NetworkService.TABLE_API.getNews().enqueue(object : Callback<ArrayList<ArrayList<String>>> {
            override fun onResponse(call: Call<ArrayList<ArrayList<String>>>, resp: Response<ArrayList<ArrayList<String>>>) {
                Log.d("EventRepository", "Good")
                var events = arrayListOf<String>()
                resp.body()?.forEach {
                    events.add(it[1])
                }
                allEventLiveData.value = events.toCollection(arrayListOf()) //TODO: handle error response
            }

            override fun onFailure(call: Call<ArrayList<ArrayList<String>>>, t: Throwable) {
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