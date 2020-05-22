package com.example.bonchapp.presentation.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.ui.event.main.IEventView
import com.example.bonchapp.presentation.ui.event.main.IMainEventView

interface IMainEventPresenter: IEventPresenter {

    override fun getAttachView(): IMainEventView
    fun attachView(viewMain: IMainEventView)
    fun onItemLike(event: Event)

}