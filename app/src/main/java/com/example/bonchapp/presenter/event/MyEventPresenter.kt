package com.example.bonchapp.presenter.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.repository.EventRepository
import com.example.bonchapp.ui.event.my.MyEventFragment

class MyEventPresenter(override val fragment: MyEventFragment): Presenter {

    private val _testData =
        MutableLiveData<ArrayList<String>>().apply { value = arrayListOf("Load!") }

    var testData: LiveData<ArrayList<String>> = _testData

    override fun onItemClick(position: Int) {
        MainCoordinator.navigateToFullEvent(fragment, position)
    }

    override fun onItemLike(it1: String) {
        EventRepository.addLikeEvent(it1)
    }

    fun onChangeTab(pos: Int){
        when(pos){
            0 -> MainCoordinator.changeMyEventFragment(fragment, fragment.getFutureEventFragment())
            1 -> MainCoordinator.changeMyEventFragment(fragment, fragment.getPastEventFragment())
            2 -> MainCoordinator.changeMyEventFragment(fragment, fragment.getApplicationEventFragment())
            else -> MainCoordinator.changeMyEventFragment(fragment, fragment.getFutureEventFragment())
        }
    }

    fun onStart(){
        MainCoordinator.changeMyEventFragment(fragment, fragment.getFutureEventFragment())
        testData = EventRepository.getLikeEvent()
    }

}