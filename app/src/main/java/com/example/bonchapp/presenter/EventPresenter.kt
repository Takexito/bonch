package com.example.bonchapp.presenter

import androidx.fragment.app.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.repository.TestRep
import com.example.bonchapp.ui.event.EventFragment
import com.example.bonchapp.ui.event.FullEventFragment

class EventPresenter(val context: EventFragment) {

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    fun onItemClick(pos: Int) {
        //MainCoordinator.navigateToFullEvent(context, pos)
        context.activity!!.supportFragmentManager.beginTransaction().add(FullEventFragment(), null).commit()
    }

    fun setDataFromApi() {
        TestRep.getGroups(_testData)
    }

}