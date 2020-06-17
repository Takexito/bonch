package com.example.bonchapp.presentation.presenter.event

import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.interactors.event.IEventInteractor
import com.example.bonchapp.presentation.ui.event.main.IEventView
import com.example.bonchapp.presentation.ui.event.main.IMainEventView
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject


class MainEventPresenter @Inject constructor(private val interactor: IEventInteractor, val router: MainRouter): IMainEventPresenter {

    private lateinit var viewMain: IMainEventView

    override fun firstLoad() {
        interactor.getAllEvents(
            callback = {
                viewMain.updateRecycler(it)
            },
            errorCallback = {
                viewMain.showError(it)
            }
        )
    }

    override fun onItemClick(event: Event) {
        router.navigateToFullEvent(event.id)
    }

    override fun onItemLike(event: Event) {
        interactor.addToFavorite(event,
            callback = {
                //viewMain.addToFavorite(event)
            },
            errorCallback = {
            viewMain.showError(it)
            }
        )
    }

    override fun getAttachView(): IMainEventView {
        return viewMain
    }

    override fun attachView(viewMain: IMainEventView) {
        this.viewMain = viewMain
    }

    override fun attachView(view: IEventView) {
        TODO("Not yet implemented")
    }

    override fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?) {
        viewMain.getRecyclerFilter().filter(query)
    }

}