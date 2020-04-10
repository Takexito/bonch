package com.example.bonchapp.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.ui.event.main.EventAdapter
import com.example.bonchapp.ui.event.main.MainEventFragment
import kotlinx.android.synthetic.main.item_event.*

class EventPresenter(override val fragment: MainEventFragment): Presenter {

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    override fun onItemClick(position: Int) {
        MainCoordinator.navigateToFullEvent(fragment, position)
    }

    override fun onItemLike(it1: String) {
        fragment.favoriteEventButton.setBackgroundColor(R.color.colorOrange)
        EventRepository.addLikeEvent(it1)
    }

    fun onViewCreate() {
        EventRepository.getGroups(_testData)
    }

    fun onSearchQueryUpdate(
        eventRecyclerView: RecyclerView,
        query: String?
    ) {
        (eventRecyclerView.adapter as EventAdapter).filter.filter(query)
    }

    fun onFabClick() {
        MainCoordinator.navigateToAddEvent(fragment)
    }


}