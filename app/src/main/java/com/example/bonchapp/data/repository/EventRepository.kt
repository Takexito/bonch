package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.repository.IEventRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(val networkService: NetworkService): IEventRepository {

    override fun getAllEvents(callback: (data: List<Event>?, error: String?) -> Unit) {
        Log.d("EventRepository", "request")
        networkService.getEvents().enqueue(object : Callback<List<Event>> {
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