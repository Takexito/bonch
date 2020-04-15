package com.example.bonchapp.interactor.event

import com.example.bonchapp.coordinator.EventTags
import com.example.bonchapp.model.pojo.Event
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.model.repository.IEventRepository

class EventInteractor : IEventInteractor {

    private val repository: IEventRepository = EventRepository()



    override fun getAllEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit){
        repository.getAllEvents { data, error ->
            if (error != null) errorCallback(error)
            if (data != null) callback(data)
        }
    }

    override fun getAllEvents(
        timeout: Int,
        callback: (data: List<Event>) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.getAllEvents { data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            if (data != null) callback(data)
        }
    }

    override fun getFavoriteEvents(
        callback: (data: List<Event>) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.getFavoriteEvent { data, error ->
            if (error != null) errorCallback(error)
            if (data != null) callback(data)
        }
    }

    override fun getFavoriteEvents(
        timeout: Int,
        callback: (data: List<Event>) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.getFavoriteEvent { data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            if (data != null) callback(data)
        }      }

    override fun getMyEvents(
        callback: (data: List<Event>) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.getMyEvents{ data, error ->
            if (error != null) errorCallback(error)
            if (data != null) callback(data)
        }
    }

    override fun getMyEvents(
        timeout: Int,
        callback: (data: List<Event>) -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.getMyEvents{ data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            if (data != null) callback(data)
        }
    }

    override fun deleteFavoriteEvent(
        eventId: Int,
        callback: () -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
       repository.deleteFavoriteEvent(eventId) {
           if (it != null) errorCallback(it)
           else callback
       }
    }

    override fun addToFavorite(
        eventId: Int,
        callback: () -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        repository.addFavoriteEvent(eventId){
            if (it != null) errorCallback(it)
            else callback
        }
    }

    override fun filterByTag(tag: EventTags) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchEvents(query: String): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun repeatRequest(t: Int, timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit) {
        val i = t + 1
        if (i < timeout){
            repository.getAllEvents { data, error ->
                if (error != null) {
                    errorCallback(error)
                    repeatRequest(i, timeout, callback, errorCallback)
                }
                if (data != null) callback(data)
            }
        }
    }
}