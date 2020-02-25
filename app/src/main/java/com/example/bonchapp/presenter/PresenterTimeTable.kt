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
import java.util.*


class PresenterTimeTable(fr: Fragment, view: MainContract.View) : MainContract.Presenter {
    val mView = view
    var mModel = ModelTimetable()
    val fragment = fr
    lateinit var timetable: List<SubjectDTO>

    override fun swithDay(day: String) {
        val body = RequestDTO(0, Info(text = "ИКПИ-84"), Date(day))

        mModel.loadTimetable(body).observe(fragment.viewLifecycleOwner, Observer {
            timetable = it
            mView.showTimetable(timetable)
        })
    }

}