package com.example.bonchapp.model.repository

import androidx.lifecycle.MutableLiveData

interface IEventRepository {

    fun getAllEvents(): MutableLiveData<ArrayList<String>>
    fun getFavoriteEvent(): MutableLiveData<ArrayList<String>>
    fun getMyEvents(): MutableLiveData<ArrayList<String>>
    fun addFavoriteEvent(event: String)

}