package com.example.bonchapp.model.repository

import androidx.lifecycle.MutableLiveData

interface IEventRepository {

    fun getAllEvents(liveData: MutableLiveData<ArrayList<String>>)
    fun getFavoriteEvent(liveData: MutableLiveData<ArrayList<String>>)
    fun getMyEvents(liveData: MutableLiveData<ArrayList<String>>)
    fun addFavoriteEvent(event: String)

}