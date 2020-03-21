package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.pojo.SubjectDTO
import kotlin.collections.ArrayList

interface MainContract {

    interface View {
        fun showTimetable(timetable: List<SubjectDTO>)
        fun showGroupsList(list: List<String>)
        fun showSelectProfessorFragment()
        fun showSelectGroupFragment()
        fun setNameGroup(name:String)
        fun setMissingGroupVisibility(b:Boolean)
        fun setWithoutClassesVisibility(b:Boolean)
    }

    interface Presenter {
        fun updateTimetable(day: String)
        fun updateGroupsList()
        fun updateTutorsList()
        fun switchTimetable(type: String)
        fun switchGroup(name:String, type:String)
    }

    interface Model {
        fun loadTimetable(body: RequestTimeTableDTO): LiveData<ArrayList<SubjectDTO>>
        fun getGroups(): LiveData<ArrayList<String>>
        fun getTutors(): LiveData<ArrayList<String>>
    }
}