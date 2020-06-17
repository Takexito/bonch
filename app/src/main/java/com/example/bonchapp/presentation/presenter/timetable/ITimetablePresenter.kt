package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presentation.timetable.ui.ITimetableView
import com.example.bonchapp.presentation.ui.timetable.main.TimetableViewPagerFragment
import org.joda.time.DateTime

interface ITimetablePresenter {
    fun getAttachView(): ITimetableView
    fun attachView(viewMain: ITimetableView)
    fun updateTimetable(fragment: TimetableViewPagerFragment, date:DateTime, callback: (data: ArrayList<SubjectDTO>?) -> Unit)
    //fun updateTimetable()
    fun switchWeek(dt: DateTime)
    //fun switchWeek(command: String)
    fun switchType(type: String)
    fun switchName(name:String)
    fun getPagersList(): ArrayList<TimetableViewPagerFragment>
    }