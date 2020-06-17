package com.example.bonchapp.presentation.ui.event.main

import android.widget.Filter
import androidx.lifecycle.LifecycleOwner
import com.example.bonchapp.domain.entities.Event

interface IEventView {
    fun setRecyclerVisible(isVisible: Boolean)
    fun getRecyclerFilter(): Filter
    fun getLifecycleOwner(): LifecycleOwner
    fun updateRecycler(data: List<Event>)
    fun showError(message: String)
    fun addToFavorite(event: Event)
}