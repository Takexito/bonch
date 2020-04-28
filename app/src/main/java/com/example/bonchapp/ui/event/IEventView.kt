package com.example.bonchapp.ui.event

import android.content.Context
import android.widget.Filter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

interface IEventView {
    fun getFragmentContext(): Context
    fun getFragment(): Fragment
    fun setRecyclerVisible(isVisible: Boolean)
    fun getRecyclerFilter(): Filter
    fun getLifecycleOwner(): LifecycleOwner
    fun updateRecycler(data: List<String>)
}