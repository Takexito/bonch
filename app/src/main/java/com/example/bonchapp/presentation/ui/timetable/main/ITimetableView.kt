package com.example.bonchapp.presentation.timetable.ui

import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime

interface ITimetableView {
    fun updateTimetable(timetable: ArrayList<SubjectDTO>, date: DateTime)
    fun closeFragment()
    fun showSelectGroupFragment()
    fun showSelectTutorFragment()
    fun showName(s:String)
}