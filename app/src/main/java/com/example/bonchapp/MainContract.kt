package com.example.bonchapp

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import java.util.*
import kotlin.collections.ArrayList

interface MainContract {

    interface View {
        fun showTimetable(timetable: List<SubjectDTO>)
    }

    interface Presenter {
        fun swithDay(day: String)
    }

    interface Model{
        fun loadTimetable(body: RequestDTO): LiveData<ArrayList<SubjectDTO>>
    }
}