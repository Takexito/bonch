package com.example.bonchapp.domain.repository

import com.example.bonchapp.domain.entities.Event

interface IEventRepository {

    fun getAllEvents(callback: (data: List<Event>?, error: String?) -> Unit)
    fun getFavoriteEvent(callback: (data: List<Event>?, error: String?) -> Unit)
    fun getMyEvents(callback: (data: List<Event>?, error: String?) -> Unit)
    fun addFavoriteEvent(event: Event, callback: (error: String?) -> Unit)
    fun deleteFavoriteEvent(event: Event, callback: (error: String?) -> Unit)
    fun addMyEvent(event: Event, callback: (error: String?) -> Unit)
    fun deleteMyEvent(event: Event, callback: (error: String?) -> Unit)

}