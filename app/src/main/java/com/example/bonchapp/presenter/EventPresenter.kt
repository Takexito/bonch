package com.example.bonchapp.presenter

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import com.example.bonchapp.model.repository.TestRep
import com.example.bonchapp.ui.event.EventFragment

class EventPresenter(val context: EventFragment) : ViewModel() {


    private val _testData = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Error!") }

    var testData: LiveData<ArrayList<String>> = _testData

    fun onItemClick(pos: Int) {
        navigateToFullEvent(pos)
    }

    private fun navigateToFullEvent(eventId: Int) {
        val bundle = Bundle()
        bundle.putInt("eventId", eventId)
        context.findNavController()
            .navigate(R.id.action_navigation_event_to_fullEventFragment, bundle)
    }

    fun setData() {
        testData = TestRep.getGroups()
    }


}