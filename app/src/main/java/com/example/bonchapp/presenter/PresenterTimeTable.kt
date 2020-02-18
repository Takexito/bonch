package com.example.bonchapp.presenter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.bonchapp.MainContract
import com.example.bonchapp.model.pojo.ModelTimetable
import com.example.bonchapp.pojo.SubjectDTO
import java.util.*


class PresenterTimeTable(view: MainContract.View) : MainContract.Presenter, LifecycleOwner {
    val mView = view
    var mModel = ModelTimetable()
    lateinit var timetable: List<SubjectDTO>
    override fun swithDay(day: Date) {
        val date:Date
        date = Date(2020, 2, 17)

        mModel.loadTimetable(date).observe(this, Observer {
            timetable = it
            mView.showTimetable(timetable)
        })
    }

    override fun getLifecycle(): Lifecycle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}