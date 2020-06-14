package com.example.bonchapp.presentation.ui.timetable.selectGroup

import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime

interface ITimetableGroupView {
    fun setList(list: ArrayList<ArrayList<String>>)
}