package com.example.bonchapp.presenter.event

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.interactor.event.EventInteractor
import com.example.bonchapp.interactor.event.IEventInteractor
import com.example.bonchapp.ui.event.IEventView

class EventPresenter(override val view: IEventView): IEventPresenter {

    private val interactor: IEventInteractor = EventInteractor()
    private val router = MainRouter()

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
        router.navigateToFullEvent(view.getFragment(), position)
    }

    override fun onItemLike(eventId: Int) {
        //repository.addFavoriteEvent(it1)
        interactor.addToFavorite(eventId, {},{
            Toast.makeText(view.getFragmentContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onSearchQueryUpdate(recyclerView: RecyclerView, query: String?) {
        view.getRecyclerFilter().filter(query)
    }

}