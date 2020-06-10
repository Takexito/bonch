package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.db.EventStorage
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.repository.IEventRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(private val networkService: NetworkService): IEventRepository {

    var isLocal = true

    override fun getAllEvents(callback: (data: List<Event>?, error: String?) -> Unit) {

        if(isLocal){
            callback(getAllEventsLocal(), null)
        }
        else {
            Log.d("EventRepository", "request")
            networkService.getEvents().enqueue(object : Callback<List<Event>> {
                override fun onResponse(call: Call<List<Event>>, resp: Response<List<Event>>) {
                    Log.d("EventRepository", "Good")
                    callback(resp.body(), resp.errorBody()?.string())
                    EventStorage.setAllEvents(resp.body()?.toCollection(ArrayList())?: arrayListOf())
                }

                override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                    Log.d("EventRepository", t.localizedMessage ?: "Error!")
                    callback(null, t.localizedMessage)
                }
            })
        }

    }

    private fun getAllEventsLocal(): ArrayList<Event>{
        return EventStorage.events
    }

    override fun getFavoriteEvent(callback: (data: List<Event>?, error: String?) -> Unit) {
        callback(EventStorage.favoriteEvents, null)
    }

    override fun getMyEvents(callback: (data: List<Event>?, error: String?) -> Unit) {
        callback(EventStorage.myEvents, null)
    }

    override fun addFavoriteEvent(event: Event, callback: (error: String?) -> Unit) {
        EventStorage.addFavoriteEvent(event)
        callback(null)
    }

    override fun deleteFavoriteEvent(event: Event, callback: (error: String?) -> Unit) {
        EventStorage.deleteFavoriteEvent(event)
        callback(null)
    }

    override fun addMyEvent(event: Event, callback: (error: String?) -> Unit) {
        EventStorage.addMyEvent(event)
        callback(null)
    }

    override fun deleteMyEvent(event: Event, callback: (error: String?) -> Unit) {
        EventStorage.deleteMyEvent(event)
        callback(null)
    }


//    val allEventLiveData = MutableLiveData<ArrayList<String>>()
//    val favoriteEventLiveData = MutableLiveData<ArrayList<String>>()
//    val myEventLiveData = MutableLiveData<ArrayList<String>>()
//
//    override fun getAllEvents():MutableLiveData<ArrayList<String>> {
//        return getAllEventsRetrofit()
//    }
//
//    private fun getAllEventsRetrofit(): MutableLiveData<ArrayList<String>>{
//        Log.d("EventRepository", "request")
//        NetworkService.TABLE_API.getNews().enqueue(object : Callback<ArrayList<ArrayList<String>>> {
//            override fun onResponse(call: Call<ArrayList<ArrayList<String>>>, resp: Response<ArrayList<ArrayList<String>>>) {
//                Log.d("EventRepository", "Good")
//                var events = arrayListOf<String>()
//                resp.body()?.forEach {
//                    events.add(it[1])
//                }
//                allEventLiveData.value = events.toCollection(arrayListOf()) //TODO: handle error response
//            }
//
//            override fun onFailure(call: Call<ArrayList<ArrayList<String>>>, t: Throwable) {
//                Log.d("EventRepository", t.localizedMessage ?: "Error!")
//            }
//        })
//        return allEventLiveData
//    }
//
//    override fun getFavoriteEvent(): MutableLiveData<ArrayList<String>> {
//        return favoriteEventLiveData
//    }
//
//    override fun addFavoriteEvent(event: String) {
//        Log.d("Like", "add $event")
//    }
//
//    override fun getMyEvents(): MutableLiveData<ArrayList<String>>{
//        return myEventLiveData
//    }
}