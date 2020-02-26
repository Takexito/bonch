package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import kotlin.collections.ArrayList

interface MainContract {

    interface View {
        fun showTimetable(timetable: List<SubjectDTO>)
        fun showSwitchProfessorFragment()
        fun showSwitchGroupFragment()

    }

    interface Presenter {
        fun updateTimetable(day: String)
        fun switchTimetable(type: Int)
    }

    interface Model {
        fun loadTimetable(body: RequestDTO): LiveData<ArrayList<SubjectDTO>>
    }
}