package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import kotlin.collections.ArrayList

interface MainContract {

    interface View {
        fun showTimetable(timetable: List<SubjectDTO>)
        fun showGroupsList(list: List<String>)
        fun showSwitchProfessorFragment()
        fun showSwitchGroupFragment()
        fun setNameGroup(name:String)
    }

    interface Presenter {
        fun updateTimetable(day: String)
        fun updateGroupsList()
        fun switchTimetable(type: String)
    }

    interface Model {
        fun loadTimetable(body: RequestDTO): LiveData<ArrayList<SubjectDTO>>
        fun getGroups(): LiveData<ArrayList<String>>
    }
}