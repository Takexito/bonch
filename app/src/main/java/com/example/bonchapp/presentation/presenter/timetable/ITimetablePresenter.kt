package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.presentation.ui.timetable.main.ITimetableView
import org.joda.time.DateTime

interface ITimetablePresenter {
    fun getAttachView(): ITimetableView
    fun attachView(viewMain: ITimetableView)
    fun loadTimetable()
    fun switchWeek(dt: DateTime)
    fun switchType(type: String)
    fun switchName(name:String)
    fun closeFragment()
    fun returnOriginal()
    fun navigateToCabinet(cabinet: String)
    fun navigateToSelectType()
    fun firstLoad()
    }