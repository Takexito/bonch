package com.example.bonchapp.presenter.event

import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.ui.event.my.MyEventFragment

class MyEventPresenter(val context: MyEventFragment) {
    fun onChangeTab(pos: Int){
        when(pos){
            0 -> MainCoordinator.changeMyEventFragment(context, context.getFutureEventFragment())
            1 -> MainCoordinator.changeMyEventFragment(context, context.getPastEventFragment())
            2 -> MainCoordinator.changeMyEventFragment(context, context.getApplicationEventFragment())
            else -> MainCoordinator.changeMyEventFragment(context, context.getFutureEventFragment())
        }
    }

    fun onStart(){
        MainCoordinator.changeMyEventFragment(context, context.getFutureEventFragment())
    }
}