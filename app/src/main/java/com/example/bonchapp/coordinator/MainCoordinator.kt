package com.example.bonchapp.coordinator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavOptionsDsl
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import com.example.bonchapp.ui.event.FullEventFragment
import kotlinx.android.synthetic.main.activity_main.*

object MainCoordinator {

    fun navigateToFullEvent(context: Fragment, eventId: Int) {
        context.arguments = Bundle().apply { putInt(Keys.FULL_EVENT_ID, eventId) }
        context.activity!!.supportFragmentManager.beginTransaction().add(FullEventFragment(), null)
            .commit()
    }

    fun navigateToAddEvent(fragment: Fragment) {
        fragment.findNavController().navigate(R.id.action_navigation_event_to_addEvent)
    }

    fun changeMyEventFragment(context: Fragment, fragment: Fragment){
        context.activity!!.supportFragmentManager.beginTransaction().replace(R.id.my_event_fragment_view, fragment).commit()
    }

    //Function for open navigator fragment with showing cabinet
    //Accepts cabinet number as argument. Example: 552/4; 522/4/1; 122 (for college)
    fun showCabinetInNavigator(context: Fragment, cabinet: String) {
        val bundle = Bundle()
        bundle.putString("cabinet", cabinet)
        context.findNavController().navigate(R.id.navigation_navgut, bundle)
    }

    fun navigateToTimetable(context: Fragment) {
        context.activity!!.nav_view.visibility = View.VISIBLE
        context.findNavController().navigate(R.id.action_navigation_authorization_to_navigation_timetable)
    }
}