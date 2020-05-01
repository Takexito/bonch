package com.example.bonchapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.ui.event.main.EventPagerAdapter
import com.example.bonchapp.ui.profile.main.ProfilePagerAdapter
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_main_event.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewPager.adapter =
            ProfilePagerAdapter(this)
        profileTabLayout.setupWithViewPager(profileViewPager)
        initBtn()
    }

    private fun initBtn(){
        settings.setOnClickListener{
            //presenter.onFabClick()
            MainCoordinator.navigateToSettings(this)
        }
    }
}
