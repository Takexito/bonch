package com.example.bonchapp.ui.profile.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.bonchapp.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.ui.profile.electives.ProfileElectivesFragment
import com.example.bonchapp.ui.profile.recordbook.ProfileRecordbookFragment

class ProfilePagerAdapter(val fragment: Fragment, val debt: ProfileDebtFragment, val rec:ProfileRecordbookFragment, val elec:ProfileElectivesFragment): FragmentPagerAdapter(fragment.fragmentManager!!) {
    private val tabs = arrayOf("Задолженность", "Зачетка","Файлы группы","Факультативы")
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> {
                debt
            }
            1-> {
                rec
            }
            2 -> {
                ProfileDebtFragment()
            }
            3 -> {
                elec
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