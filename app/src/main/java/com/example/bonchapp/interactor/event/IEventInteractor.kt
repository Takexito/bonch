package com.example.bonchapp.interactor.event

import com.example.bonchapp.model.pojo.Event


interface IEventInteractor{

    fun getAllEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getAllEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

    fun getFavoriteEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getFavoriteEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

    fun getMyEvents(callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)
    fun getMyEvents(timeout: Int, callback: (data: List<Event>) -> Unit, errorCallback: (error: String) -> Unit)

    fun deleteFavoriteEvent(eventId: Int, callback: () -> Unit, errorCallback: (error: String) -> Unit)
    fun addToFavorite(eventId: Int, callback: () -> Unit, errorCallback: (error: String) -> Unit)

    fun filterByTag()
    fun searchEvents(query: String): List<Event>

}