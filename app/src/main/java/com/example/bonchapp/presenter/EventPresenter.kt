package com.example.bonchapp.presenter

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.Event
import com.example.bonchapp.ui.event.EventFragment

class EventPresenter(val context: EventFragment) {

    val data = arrayListOf<Event>(
        Event(),
        Event("title1", "SubTitle1"),
        Event("title2", "SubTitle2"),
        Event("title3", "SubTitle3"),
        Event("title4", "SubTitle4")
    )

    fun onCreate() {
        //setData()
        context.initRecycler(data)
    }

    fun onItemClick(pos: Int) {
        navigateToFullEvent(pos)
    }

    private fun navigateToFullEvent(eventId: Int) {
        val bundle = Bundle()
        bundle.putInt("eventId", eventId)
        context.findNavController().navigate(R.id.action_navigation_event_to_fullEventFragment, bundle)
    }

    private fun setData(){
        TODO("request and parse data")
    }
}