package com.example.bonchapp.presenter.event

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.coordinator.Keys
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.interactor.event.EventInteractor
import com.example.bonchapp.interactor.event.IEventInteractor
import com.example.bonchapp.model.pojo.Event
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.model.repository.IEventRepository
import com.example.bonchapp.ui.event.IEventView
import com.example.bonchapp.ui.event.main.EventAdapter
import com.example.bonchapp.ui.event.main.MainEventFragment

class EventPresenter(override val view: IEventView): IEventPresenter {

    private val interactor: IEventInteractor = EventInteractor()
    private val router = MainCoordinator()

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