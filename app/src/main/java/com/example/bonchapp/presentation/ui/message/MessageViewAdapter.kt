package com.example.bonchapp.presentation.ui.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_PAGES = 2

class MessageViewAdapter(fragment: Fragment, val adapter: MessageAdapter): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MessageInFragment(true, adapter)
            1 -> MessageInFragment(false, adapter)
            else -> MessageInFragment(true, adapter)
        }
    }
}