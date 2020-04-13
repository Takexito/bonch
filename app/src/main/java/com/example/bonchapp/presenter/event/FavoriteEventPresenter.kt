package com.example.bonchapp.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.model.repository.IEventRepository
import com.example.bonchapp.ui.event.IEventView

class FavoriteEventPresenter(override val view: IEventView) : IEventPresenter {

    private val repository: IEventRepository = EventRepository()

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    override fun onSearchQueryUpdate(
        recyclerView: androidx.recyclerview.widget.RecyclerView,
        query: String?
    ) {
        view.getRecyclerFilter().filter(query)
    }

    override fun onStart() {
        repository.getMyEvents()
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
    }

    override fun onItemClick(position: Int) {
    }

    override fun onItemLike(it1: String) {
        repository.addFavoriteEvent(it1)
    }
}