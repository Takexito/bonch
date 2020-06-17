package com.example.bonchapp.presentation.presenter.event

import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.ui.event.favorite.IFavoriteEventView

interface IFavoriteEventPresenter: IEventPresenter {
    override fun getAttachView(): IFavoriteEventView
    fun attachView(view: IFavoriteEventView)
    fun onItemLike(event: Event)
}