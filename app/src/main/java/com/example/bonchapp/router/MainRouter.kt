package com.example.bonchapp.router

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import javax.inject.Singleton

class MainRouter {
    lateinit var navController: NavController

//    fun navigateToFullEvent(eventId: Int) {
//        val bundle = Bundle()
//        bundle.putInt(Constants.FULL_EVENT_ID, eventId)
//        navController.navigate(R.id.action_navigation_event_to_fullEventFragment)
//    }
//
//    fun navigateToAddEvent() {
//        navController.navigate(R.id.action_navigation_event_to_addEvent)
//    }

    fun navigateToCabinet(cabinet: String) {
        val bundle = Bundle()
        bundle.putString(Constants.CABINET_BUNDLE_ID, cabinet)
        navController.navigate(R.id.navigation_navgut, bundle)
    }

    fun navigateToTimetable() {
        //context.requireActivity().nav_view.visibility = View.VISIBLE
        //navController.navigate(R.id.action_navigation_authorization_to_navigation_timetable)
    }

    fun showCabinetInNavigator(context: Fragment, cabinet: String) {
        val bundle = Bundle()
        bundle.putString("cabinet", cabinet)
        context.findNavController().navigate(R.id.navigation_navgut, bundle)
    }


}
