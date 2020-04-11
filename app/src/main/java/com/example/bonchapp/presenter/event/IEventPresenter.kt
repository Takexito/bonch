package com.example.bonchapp.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.ui.event.IEventView

interface IEventPresenter {

    val view: IEventView

    fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onDestroy()
    fun onItemClick(position: Int)
    fun onItemLike(it1: String)
}