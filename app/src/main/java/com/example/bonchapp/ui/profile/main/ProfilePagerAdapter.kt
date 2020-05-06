package com.example.bonchapp.ui.profile.main

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bonchapp.ui.event.favorite.FavoriteEventFragment
import com.example.bonchapp.ui.event.main.MainEventFragment
import com.example.bonchapp.ui.event.my.MyEventFragment
import com.example.bonchapp.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.ui.profile.electives.ProfileElectivesFragment
import com.example.bonchapp.ui.profile.recordbook.ProfileRecordbookFragment

class ProfilePagerAdapter(val fragment: Fragment): FragmentPagerAdapter(fragment.fragmentManager!!) {
    private val tabs = arrayOf("Задолженность", "Зачетка","Файлы группы","Факультативы")
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                ProfileDebtFragment()
            }
            1-> {
                ProfileRecordbookFragment()
            }
            2 -> {
                ProfileElectivesFragment()
            }
            3 -> {
                ProfileElectivesFragment()
            }
            else -> {
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