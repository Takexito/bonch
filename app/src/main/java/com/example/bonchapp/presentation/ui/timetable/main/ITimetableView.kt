package com.example.bonchapp.presentation.ui.timetable.main

import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime

interface ITimetableView {
    fun hideKeyboard()
    fun showName(s:String)
}