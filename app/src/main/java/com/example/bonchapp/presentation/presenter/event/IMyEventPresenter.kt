package com.example.bonchapp.presentation.presenter.event

import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.ui.event.my.IMyEventView

interface IMyEventPresenter: IEventPresenter {
    override fun getAttachView(): IMyEventView
    fun attachView(viewMain: IMyEventView)
    fun onItemLike(event: Event)

}