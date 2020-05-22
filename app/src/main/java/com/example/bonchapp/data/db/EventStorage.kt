package com.example.bonchapp.data.db

import com.example.bonchapp.domain.entities.Event

object EventStorage {
    val events: ArrayList<Event> = arrayListOf()
    val favoriteEvents: ArrayList<Event> = arrayListOf()
    val myEvents: ArrayList<Event> = arrayListOf()

    fun addFavoriteEvent(event: Event){
        favoriteEvents.add(event)
    }

    fun deleteFavoriteEvent(event: Event){
        favoriteEvents.remove(event)
    }

    fun addMyEvent(event: Event){
        myEvents.add(event)
    }

    fun deleteMyEvent(event: Event){
        myEvents.remove(event)
    }

    fun setAllEvents(events: ArrayList<Event>){
        events.clear()
        events.forEach{
            this.events.add(it)
        }
    }
}