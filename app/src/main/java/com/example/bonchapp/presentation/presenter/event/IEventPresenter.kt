package com.example.bonchapp.presentation.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.presentation.ui.event.IEventView

interface IEventPresenter {

    fun getAttachView(): IEventView
    fun attachView(view: IEventView)
    fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?)
    fun firstLoad()
    fun onItemClick(position: Int)
    fun onItemLike(eventId: Int)

}