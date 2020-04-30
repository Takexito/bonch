package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.GroupDTO
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime
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
        fun loadTimetable(body: RequestTimeTableDTO): LiveData<ArrayList<SubjectDTO>>
        fun getGroups(): LiveData<ArrayList<ArrayList<String>>>
        fun getTutors(): LiveData<ArrayList<String>>
    }
}