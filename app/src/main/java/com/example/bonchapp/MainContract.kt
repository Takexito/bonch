package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.pojo.SubjectDTO
import java.util.*

interface MainContract {

    interface View {
        fun showTimetable(timetable: List<SubjectDTO>)
    }

    interface Presenter {
        fun swithDay(day: Date)
    }

    interface Model{
        fun loadTimetable(day: Date): LiveData<List<SubjectDTO>>
    }
}