package com.example.bonchapp.presenter

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bonchapp.MainContract
import com.example.bonchapp.model.pojo.Date
import com.example.bonchapp.model.pojo.Info
import com.example.bonchapp.model.ModelTimetable
import com.example.bonchapp.model.pojo.RequestTimeTableDTO
import com.example.bonchapp.pojo.SubjectDTO
import java.text.SimpleDateFormat


class PresenterTimeTable(fr: Fragment, view: MainContract.View) : MainContract.Presenter {
    val mView = view
    var mModel = ModelTimetable()
    val fragment = fr

    var name = "ИКПИ-84"
    var type = "group"

    lateinit var timetable: List<SubjectDTO>
    lateinit var groupsList:List<String>

    lateinit var activeday:String

    init {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        activeday = sdf.format(java.util.Date())
        updateTimetable(activeday)
    }

    override fun updateTimetable(day: String) {
        activeday = day
        val body = RequestTimeTableDTO(0, Info(type, name), Date(activeday))

        mModel.loadTimetable(body).observe(fragment.viewLifecycleOwner, Observer {
            timetable = it
            mView.showTimetable(timetable)
        })
    }

    override fun updateGroupsList() {
        mModel.getGroups().observe(fragment.viewLifecycleOwner, Observer {
            groupsList = it
            mView.showGroupsList(groupsList)
        })
    }

    override fun switchTimetable(type: String) {
        this.type = type
        if (type == "group")
            mView.showSwitchGroupFragment()
        else
            mView.showSwitchProfessorFragment()
    }

    fun switchGroup(name:String, type:String){
        this.name = name
        this.type = type

        updateTimetable(activeday)

        mView.setNameGroup(name)

        fragment.activity?.onBackPressed()
    }
}