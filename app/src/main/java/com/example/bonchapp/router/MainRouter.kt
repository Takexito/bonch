package com.example.bonchapp.router

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import com.example.bonchapp.presentation.ui.event.FullEventFragment
import com.example.bonchapp.domain.util.Consts

class MainRouter() {

    lateinit var navController: NavController

    fun navigateToFullEvent(eventId: Int) {
        val bundle = Bundle()
        bundle.putInt(Consts.FULL_EVENT_ID, eventId)
        navController.navigate(R.id.action_navigation_event_to_fullEventFragment)
    }

    fun navigateToAddEvent() {
        navController.navigate(R.id.action_navigation_event_to_addEvent)
    }

    fun navigateToCabinet(cabinet: String) {
        val bundle = Bundle()
        bundle.putString(Consts.CABINET_BUNDLE_ID, cabinet)
        navController.navigate(R.id.navigation_navgut, bundle)
    }
}