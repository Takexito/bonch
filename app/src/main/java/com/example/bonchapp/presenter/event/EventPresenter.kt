package com.example.bonchapp.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.model.repository.IEventRepository
import com.example.bonchapp.ui.event.IEventView
import com.example.bonchapp.ui.event.main.EventAdapter
import com.example.bonchapp.ui.event.main.MainEventFragment

class EventPresenter(override val view: IEventView): IEventPresenter {

    private val repository: IEventRepository = EventRepository()
    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData
    override fun onStart() {
        repository.getAllEvents(_testData)
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
    }

    override fun onItemClick(position: Int) {
        MainCoordinator.navigateToFullEvent(view.getFragment(), position)
    }

    override fun onItemLike(it1: String) {
        repository.addFavoriteEvent(it1)
    }

    override fun onSearchQueryUpdate(
        recyclerView: RecyclerView,
        query: String?
    ) {
        view.getRecyclerFilter().filter(query)
    }

    fun onFabClick() {
        MainCoordinator.navigateToAddEvent(view.getFragment())
    }


}