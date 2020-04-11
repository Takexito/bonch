package com.example.bonchapp.ui.event

import android.content.Context
import android.widget.Filter
import androidx.fragment.app.Fragment

interface IEventView {
    fun getFragmentContext(): Context
    fun getFragment(): Fragment
    fun setRecyclerVisible(isVisible: Boolean)
    fun getRecyclerFilter(): Filter
}