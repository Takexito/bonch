package com.example.bonchapp.presentation.presenter.message

import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.presentation.ui.message.IMessageView

interface IMessagePresenter {

    fun getAttachView(): IMessageView
    fun attachView(view: IMessageView)
    fun firstLoad()
    fun onItemClick(item: Message)
    fun onFabClick()
    fun loadInMessage()
    fun loadOutMessage()
}
