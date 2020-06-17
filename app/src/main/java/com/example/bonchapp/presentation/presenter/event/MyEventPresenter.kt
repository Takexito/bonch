package com.example.bonchapp.presentation.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.interactors.event.IEventInteractor
import com.example.bonchapp.presentation.ui.event.main.IEventView
import com.example.bonchapp.presentation.ui.event.main.IMainEventView
import com.example.bonchapp.presentation.ui.event.my.IMyEventView
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject

class MyEventPresenter @Inject constructor(val interactor: IEventInteractor, val router: MainRouter): IMyEventPresenter {

    lateinit var view: IMyEventView

    override fun onItemClick(event: Event) {
        router.navigateToFullEvent(event.id)
    }

    override fun onItemLike(event: Event) {
        TODO("Not yet implemented")
    }


    override fun getAttachView(): IMyEventView {
        return view
    }

    override fun attachView(view: IMyEventView) {
        this.view = view
    }

    override fun attachView(view: IEventView) {
    }

    override fun onSearchQueryUpdate(
        recyclerView: RecyclerView,
        query: String?
    ) {
        view.getRecyclerFilter().filter(query)
    }

    override fun firstLoad() {
        interactor.getMyEvents(
            callback = {
                view.updateRecycler(it)
            },
            errorCallback = {
                view.showError(it)
            }
        )
    }


}