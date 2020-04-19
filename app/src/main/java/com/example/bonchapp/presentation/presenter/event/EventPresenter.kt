package com.example.bonchapp.presentation.presenter.event

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.domain.interactor.event.EventInteractor
import com.example.bonchapp.domain.interactor.event.IEventInteractor
import com.example.bonchapp.presentation.ui.event.IEventView
import javax.inject.Inject

class EventPresenter @Inject constructor(val interactor: IEventInteractor, val router: MainRouter): IEventPresenter {

    private lateinit var view: IEventView

    override fun firstLoad() {
       interactor.getAllEvents(
           callback = {
               view.updateRecycler(it)
           },
           errorCallback = {
           Toast.makeText(view.getFragmentContext(), it, Toast.LENGTH_SHORT).show()
           }
       )

    }

    override fun onItemClick(position: Int) {
        router.navigateToFullEvent(position)
    }

    override fun onItemLike(eventId: Int) {
        interactor.addToFavorite(eventId, {},{
            Toast.makeText(view.getFragmentContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getAttachView(): IEventView {
        return view
    }

    override fun attachView(view: IEventView) {
        this.view = view
    }

    override fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?) {
        view.getRecyclerFilter().filter(query)
    }

}