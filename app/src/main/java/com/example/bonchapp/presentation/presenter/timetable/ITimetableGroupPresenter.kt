package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.presentation.ui.timetable.selectGroup.ITimetableGroupView

interface ITimetableGroupPresenter {
    fun loadList()
    fun getAttachView(): ITimetableGroupView
    fun attachView(viewMain: ITimetableGroupView)
}