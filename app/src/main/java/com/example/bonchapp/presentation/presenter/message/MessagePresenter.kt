package com.example.bonchapp.presentation.presenter.message

import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.interactors.IMessageInteractor
import com.example.bonchapp.presentation.ui.message.IMessageView
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject

class MessagePresenter @Inject constructor(val interactor: IMessageInteractor, val router: MainRouter): IMessagePresenter {

    lateinit var view: IMessageView

    override fun getAttachView(): IMessageView {
        return view
    }

    override fun attachView(view: IMessageView) {
        this.view = view
    }

    override fun firstLoad() {
        interactor.getAllMessage(
            callback = {
                view.updateRecycler(it)
            },
            errorCallback = {
            view.showError(it)
        })
    }

    override fun onItemClick(item: Message) {
        router.navigateToFullMessage(item)
    }

    override fun onFabClick() {
        router.navigateToSendMessage()
    }

    override fun loadInMessage() {
        view.updateRecycler(interactor.getInMessages())
    }

    override fun loadOutMessage() {
        view.updateRecycler(interactor.getOutMessages())
    }


}