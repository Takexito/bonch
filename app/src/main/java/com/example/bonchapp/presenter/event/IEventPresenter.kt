package com.example.bonchapp.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.model.pojo.Event
import com.example.bonchapp.ui.event.IEventView

interface IEventPresenter {

    val view: IEventView

    fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?)
    fun firstLoad()
    fun onItemClick(position: Int)
    fun onItemLike(eventId: Int)
}