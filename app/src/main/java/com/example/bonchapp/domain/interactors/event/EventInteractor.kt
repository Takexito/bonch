package com.example.bonchapp.domain.interactors.event

import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.repository.IEventRepository
import javax.inject.Inject

class EventInteractor @Inject constructor(var repository: IEventRepository):
    IEventInteractor {
    override fun getAllEvents(callback: (data: List<Event>) -> Unit,
                              errorCallback: (error: String) -> Unit) {
        repository.getAllEvents { data, error ->
            if (error != null) errorCallback(error)
            else if (data != null) callback(data)
        }
    }

    override fun getAllEvents(timeout: Int,
                              callback: (data: List<Event>) -> Unit,
                              errorCallback: (error: String) -> Unit) {
        repository.getAllEvents { data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            else if (data != null) {
                callback(data)
            }
        }
    }

    override fun getFavoriteEvents(callback: (data: List<Event>) -> Unit,
                                   errorCallback: (error: String) -> Unit) {
        repository.getFavoriteEvent { data, error ->
            if (error != null) errorCallback(error)
            else if (data != null) callback(data)
        }
    }

    override fun getFavoriteEvents(timeout: Int,
                                   callback: (data: List<Event>) -> Unit,
                                   errorCallback: (error: String) -> Unit) {
        repository.getFavoriteEvent { data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            else if (data != null) callback(data)
        }
    }

    override fun getMyEvents(callback: (data: List<Event>) -> Unit,
                             errorCallback: (error: String) -> Unit) {
        repository.getMyEvents { data, error ->
            if (error != null) errorCallback(error)
            else if (data != null) callback(data)
        }
    }

    override fun getMyEvents(timeout: Int,
                             callback: (data: List<Event>) -> Unit,
                             errorCallback: (error: String) -> Unit) {
        repository.getMyEvents { data, error ->
            if (error != null) {
                errorCallback(error)
                repeatRequest(0, timeout, callback, errorCallback)
            }
            else if (data != null) callback(data)
        }
    }

    override fun deleteFavoriteEvent(event: Event,
                                     callback: () -> Unit,
                                     errorCallback: (error: String) -> Unit) {
        repository.deleteFavoriteEvent(event) {
            if (it != null) errorCallback(it)
            else callback()
        }
    }

    override fun addToFavorite(event: Event,
                               callback: () -> Unit,
                               errorCallback: (error: String) -> Unit) {
        repository.addFavoriteEvent(event) {
            if (it != null) errorCallback(it)
            else callback()
        }
    }

    private fun repeatRequest(t: Int, timeout: Int,
                              callback: (data: List<Event>) -> Unit,
                              errorCallback: (error: String) -> Unit) {
        val i = t + 1
        if (i < timeout) {
            repository.getAllEvents { data, error ->
                if (error != null) {
                    errorCallback(error)
                    repeatRequest(i, timeout, callback, errorCallback)
                }
                if (data != null) callback(data)
            }
        }
    }

    override fun filterByTag() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchEvents(query: String): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}