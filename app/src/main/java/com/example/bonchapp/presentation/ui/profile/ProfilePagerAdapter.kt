package com.example.bonchapp.presentation.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bonchapp.presentation.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.presentation.ui.profile.elective.ProfileElectivesFragment
import com.example.bonchapp.presentation.ui.profile.mark.ProfileMarkFragment

class ProfilePagerAdapter(val fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> ProfileDebtFragment()
        1 -> ProfileMarkFragment()
        2 -> ProfileDebtFragment()
        else -> ProfileElectivesFragment()
    }
}
