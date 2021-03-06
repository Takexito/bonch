package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.presentation.timetable.ui.ITimetableView
import org.joda.time.DateTime

interface ITimetablePresenter {
    fun getAttachView(): ITimetableView
    fun attachView(viewMain: ITimetableView)
    fun updateTimetable()
    fun switchWeek(dt: DateTime)
    fun switchType(type: String)
    fun switchName(name:String)
    }