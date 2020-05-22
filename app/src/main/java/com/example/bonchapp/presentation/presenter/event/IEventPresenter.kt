package com.example.bonchapp.presentation.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.ui.event.main.IEventView

interface IEventPresenter {

    fun getAttachView(): IEventView
    fun attachView(view: IEventView)
    fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?)
    fun firstLoad()
    fun onItemClick(event: Event)
}