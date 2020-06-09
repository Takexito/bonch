package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.presentation.ui.timetable.selectGroup.ITimetableGroupView
import com.example.bonchapp.presentation.ui.timetable.selectTutor.ITimetableTutorView

interface ITimetableTutorPresenter {
    fun loadList()
    fun getAttachView(): ITimetableTutorView
    fun attachView(viewMain: ITimetableTutorView)
}