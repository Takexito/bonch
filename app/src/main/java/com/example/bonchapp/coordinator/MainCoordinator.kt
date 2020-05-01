package com.example.bonchapp.coordinator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.bonchapp.R
import com.example.bonchapp.ui.event.FullEventFragment
import com.example.bonchapp.ui.timetable.SelectGroupFragment
import com.example.bonchapp.ui.timetable.SelectTypeTimetableFragment
import com.example.bonchapp.ui.timetable.mPresenter

import com.example.bonchapp.ui.event.my.ApplicationEventFragment
import kotlinx.android.synthetic.main.activity_main.*


object MainCoordinator {

    fun navigateToFullEvent(fragment: Fragment, eventId: Int) {
        val bundle = Bundle().apply { putInt(Keys.FULL_EVENT_ID, eventId) }
        fragment.activity!!.supportFragmentManager.beginTransaction().add(FullEventFragment().apply { arguments = bundle }, null)
            .commit()
    }

    fun navigateToCalendarEvent(fragment: Fragment) {
        fragment.activity!!.supportFragmentManager.beginTransaction().add(R.id.myEventContainer, ApplicationEventFragment(), null)
            .commit()
    }

    fun navigateToOrgInfo(fragment: Fragment){
        fragment.findNavController().navigate(R.id.action_fullEventFragment_to_blankFragment)
    }

    fun navigateToAddEvent(fragment: Fragment) {
        fragment.findNavController().navigate(R.id.action_navigation_event_to_addEvent)
    }

    fun navigateToSettings(fragment: Fragment) {
        fragment.findNavController().navigate(R.id.action_navigation_profile_to_SettingsFragment)
    }

    //Function for open navigator fragment with showing cabinet
    //Accepts cabinet number as argument. Example: 552/4; 522/4/1; 122 (for college)

    fun showCabinetInNavigator(context: Fragment, cabinet: String) {
        val bundle = Bundle()
        bundle.putString("cabinet", cabinet)
        context.findNavController().navigate(R.id.navigation_navgut, bundle)
    }


    /*fun showSwitchGroupFragment() {
        selectGroupFragment = SelectGroupFragment()
        activity!!.supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment ,
            selectGroupFragment, null).addToBackStack("HZ").commit()

        mPresenter.updateGroupsList()
    }*/

    fun navigateToSelectGroup(context: Fragment) {
        context.findNavController().navigate(R.id.action_navigation_timetable_to_selectGroupFragment)
    }

    fun navigateToSelectTypeTimetable(context: Fragment){
        context.activity!!.supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment,
           SelectTypeTimetableFragment(), null
        ).addToBackStack(null).commit()
   }
    fun navigateToTimetable(context: Fragment) {
        context.activity!!.nav_view.visibility = View.VISIBLE
        context.findNavController().navigate(R.id.action_navigation_authorization_to_navigation_timetable)
    }
}