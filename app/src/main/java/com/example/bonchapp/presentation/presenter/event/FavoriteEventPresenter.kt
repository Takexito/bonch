package com.example.bonchapp.presentation.presenter.event

import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.domain.interactors.event.IEventInteractor
import com.example.bonchapp.presentation.ui.event.favorite.IFavoriteEventView
import com.example.bonchapp.presentation.ui.event.main.IEventView
import com.example.bonchapp.presentation.ui.event.main.IMainEventView
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject

class FavoriteEventPresenter @Inject constructor(val interactor: IEventInteractor, val router: MainRouter) : IFavoriteEventPresenter {

    lateinit var view: IFavoriteEventView

    override fun getAttachView(): IFavoriteEventView {
        return view
    }

    override fun attachView(view: IEventView) {

    }

    override fun attachView(view: IFavoriteEventView) {
        this.view = view
    }

    override fun onSearchQueryUpdate(
        recyclerView: androidx.recyclerview.widget.RecyclerView,
        query: String?
    ) {
        view.getRecyclerFilter().filter(query)
    }

    override fun firstLoad() {
        interactor.getFavoriteEvents(
            callback = {
                view.updateRecycler(it)
            },
            errorCallback = {
                view.showError(it)
            }
        )
    }

    override fun onItemClick(event: Event) {
        router.navigateToFullEvent(event.id)
    }

    override fun onItemLike(event: Event) {
        interactor.deleteFavoriteEvent(event,{
            view.updateRecycler(it)
        },{
            view.showError(it)
        })
    }

}