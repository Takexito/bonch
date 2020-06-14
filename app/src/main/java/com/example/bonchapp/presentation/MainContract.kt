package com.example.bonchapp.presentation

import androidx.lifecycle.LiveData
import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.entities.RequestTimeTableDTO
import com.example.bonchapp.pojo.SubjectDTO
import kotlin.collections.ArrayList

interface MainContract {

    interface ITimeTableView {
        fun showTimetable(timetable: List<SubjectDTO>, datesWeeks: List<String>)
        fun showGroupsList(list: List<ArrayList<String>>)
        fun showTutorsList(list: ArrayList<String>)
        fun showSelectProfessorFragment()
        fun showSelectGroupFragment()
        fun setNameGroup(name: String)
    }

    interface ITimeTablePresenter {
        fun switchDayTimetable(day: String)
        fun updateGroupsList()
        fun updateTutorsList()
        fun switchTimetable(command: String)
        fun switchGroup(name: String, type: String)
    }

    interface ITimeTableModel {
        fun loadTimetable(body: RequestTimeTable): LiveData<ArrayList<SubjectDTO>>
        fun getGroups(): LiveData<ArrayList<ArrayList<String>>>
        fun getTutors(): LiveData<ArrayList<String>>
    }
}