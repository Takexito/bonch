package com.example.bonchapp.presentation.ui.profile.main

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bonchapp.presentation.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.presentation.ui.profile.electives.ProfileElectivesFragment
import com.example.bonchapp.presentation.ui.profile.recordbook.ProfileRecordbookFragment

class ProfilePagerAdapter(val fragment: Fragment): FragmentPagerAdapter(fragment.requireFragmentManager()) {
    private val tabs = arrayOf("Задолженность", "Зачетка","Факультативы")
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                Log.d("Lol", "start 0")
                ProfileDebtFragment()
            }
            1-> {
                Log.d("Lol", "start 1")
                ProfileRecordbookFragment()
            }
            2 -> {
                Log.d("Lol", "start 2")
                ProfileElectivesFragment()
            }
            else -> {
                Log.d("Lol", "start else")
                ProfileDebtFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    override fun getCount(): Int {
        return tabs.size
    }
}