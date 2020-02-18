package com.example.bonchapp.model.pojo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.MainContract
import com.example.bonchapp.pojo.SubjectDTO
import java.util.*

class ModelTimetable() : MainContract.Model {
    override fun loadTimetable(day: Date): LiveData<List<SubjectDTO>> {
        val timetable = MutableLiveData<List<SubjectDTO>>().apply {

        }
        return timetable
    }

}