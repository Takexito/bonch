package com.example.bonchapp.presenter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.bonchapp.MainContract
import com.example.bonchapp.model.pojo.Date
import com.example.bonchapp.model.pojo.Info
import com.example.bonchapp.model.pojo.ModelTimetable
import com.example.bonchapp.model.pojo.RequestDTO
import com.example.bonchapp.pojo.SubjectDTO
import java.text.SimpleDateFormat
import java.util.*


class PresenterTimeTable(fr: Fragment, view: MainContract.View) : MainContract.Presenter {
    val mView = view
    var mModel = ModelTimetable()
    val fragment = fr

    var name = "ИКПИ-84"
    var type = "group"

    lateinit var timetable: List<SubjectDTO>

    init {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val today = sdf.format(java.util.Date())
            updateTimetable(today)
    }

    override fun updateTimetable(day: String) {
        val body = RequestDTO(0, Info(type, name), Date(day))

        mModel.loadTimetable(body).observe(fragment.viewLifecycleOwner, Observer {
            timetable = it
            mView.showTimetable(timetable)
        })
    }

    override fun switchTimetable(type: Int) {
        if (type == 0) {
            this.type = "group"
            mView.showSwitchGroupFragment()
        } else {
            this.type = "tutor"
            mView.showSwitchProfessorFragment()
        }
    }
}