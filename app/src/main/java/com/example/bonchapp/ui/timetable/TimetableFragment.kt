package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.AdapterView.VISIBLE
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.adapters.TimetableAdapter
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.text.SimpleDateFormat
import java.util.*


class TimetableFragment : Fragment(), MainContract.View {

    private lateinit var timetableViewModel: TimetableViewModel

    lateinit var adapter: TimetableAdapter


    lateinit var mPresenter:PresenterTimeTable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_timetable, container, false)

        initRecyclerView(root)
        initCalender(root)
        //initSpinner(root)
        initSwitchTimetable(root)

        //mPresenter.updateTimetable("2020-02-26")
        mPresenter = PresenterTimeTable(this, this)

        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>) {
        adapter.setSubjects(timetable)
    }

    override fun showSwitchProfessorFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSwitchGroupFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun initRecyclerView(view: View) {
        adapter = TimetableAdapter(view.context)
        val recyclerViewDay = view.findViewById<RecyclerView>(R.id.timeTable_recyclerView)
        recyclerViewDay.layoutManager = LinearLayoutManager(view.context)
        recyclerViewDay.adapter = adapter
    }

    fun initCalender(view: View) {
        val calendar = view.findViewById<MaterialCalendarView>(R.id.calendar)
        calendar.setTopbarVisible(false)
        calendar.setOnDateChangedListener(OnDateSelectedListener { widget, date, selected ->
            val s: String = "${date.year}-${date.month}-${date.day}"
            mPresenter.updateTimetable(s)
        })
    }

    fun initSpinner(view: View) {
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View, selectedItemPosition: Int, selectedId: Long
            ) {
                //TDO("Switch time table mode")

            }
        }
    }

    fun initSwitchTimetable(view: View){
        val spinner = view.findViewById<TextView>(R.id.spinner)
        val groupName = view.findViewById<TextView>(R.id.groupName)
        val itemSwitchTimeTable = view.findViewById<View>(R.id.item_swithTimeTable)

        spinner.setOnClickListener {
            itemSwitchTimeTable.setVisibility(View.VISIBLE)
        }

        groupName.setOnClickListener {
            itemSwitchTimeTable.setVisibility(View.INVISIBLE)
        }
    }
}
