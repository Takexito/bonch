package com.example.bonchapp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.repository.TestRep
import com.example.bonchapp.ui.event.EventFragment

class EventPresenter(val context: EventFragment) {

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    fun onItemClick(pos: Int) {
        MainCoordinator.navigateToFullEvent(context, pos)
    }

    fun setDataFromApi() {
        TestRep.getGroups(_testData)
    }

}