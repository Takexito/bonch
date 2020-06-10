package com.example.bonchapp.domain.interactors.event

import com.example.bonchapp.domain.entities.Event

interface IEventInteractor {
    fun getAllEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getAllEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

    fun getFavoriteEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getFavoriteEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

    fun getMyEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getMyEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

   // fun deleteFavoriteEvent(event: Event, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun addToFavorite(event: Event, callback: () -> Unit, errorCallback: (error: String) -> Unit)

    fun filterByTag()
    fun searchEvents(query: String): List<Event>

    fun deleteFavoriteEvent(
        event: Event,
        callback: () -> Unit,
        errorCallback: (error: String) -> Unit
    )
}