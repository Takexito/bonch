package com.example.bonchapp.model.repository

import com.example.bonchapp.model.pojo.Event

interface IEventRepository {

    fun getAllEvents(callback: (data: List<Event>?, error: String?) -> Unit)
    fun getFavoriteEvent(callback: (data: List<Event>?, error: String?) -> Unit)
    fun getMyEvents(callback: (data: List<Event>?, error: String?) -> Unit)
    fun addFavoriteEvent(eventId: Int, callback: (error: String?) -> Unit)
    fun deleteFavoriteEvent(eventId: Int, callback: (error: String?) -> Unit)
}