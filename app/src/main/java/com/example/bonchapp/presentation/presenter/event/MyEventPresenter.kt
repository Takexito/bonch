package com.example.bonchapp.presentation.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.data.repository.EventRepository
import com.example.bonchapp.domain.repository.IEventRepository
import com.example.bonchapp.presentation.ui.event.IEventView
import com.example.bonchapp.router.MainCoordinator

class MyEventPresenter( val view: IEventView):
    IEventPresenter {

    //private val repository: IEventRepository = EventRepository()

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    override fun onItemClick(position: Int) {
        MainCoordinator.navigateToFullEvent(view.getFragment(), position)
    }

    override fun onItemLike(eventId: Int) {
        TODO("Not yet implemented")
    }


    override fun getAttachView(): IEventView {
        TODO("Not yet implemented")
    }

    override fun attachView(view: IEventView) {
        TODO("Not yet implemented")
    }

    override fun onSearchQueryUpdate(
        recyclerView: RecyclerView,
        query: String?
    ) {
        view.getRecyclerFilter().filter(query)
    }

    override fun firstLoad() {
        TODO("Not yet implemented")
    }


}