package com.example.bonchapp.model.repository

import android.util.Log
import com.example.bonchapp.model.network.NetworkService
import com.example.bonchapp.model.pojo.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventRepository : IEventRepository {

    override fun getAllEvents(callback: (data: List<Event>?, error: String?) -> Unit) {
        Log.d("EventRepository", "request")
        NetworkService.TABLE_API.getGroups().enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>, resp: Response<List<Event>>) {
                Log.d("EventRepository", "Good")
                callback(resp.body(), resp.errorBody()?.string())
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.d("EventRepository", t.localizedMessage ?: "Error!")
                callback(null, t.localizedMessage)
            }
        })
    }

    override fun getFavoriteEvent(callback: (data: List<Event>?, error: String?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMyEvents(callback: (data: List<Event>?, error: String?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFavoriteEvent(eventId: Int, callback: (error: String?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFavoriteEvent(eventId: Int, callback: (error: String?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}