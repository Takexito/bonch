package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.adapters.TimetableAdapter
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.calendar_sheet.view.*
import java.text.SimpleDateFormat
import java.util.*

class TimetableFragment : Fragment(), MainContract.View {

    private lateinit var timetableViewModel: TimetableViewModel

    val mPresenter = PresenterTimeTable(this, this)

    lateinit var adapter: TimetableAdapter

    val sdf = SimpleDateFormat("dd/M/yyyy")
    val selectedDay = sdf.format(Date())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_timetable, container, false)

        initRecyclerView(root)

        mPresenter.swithDay("2020-02-27")

        initCalender(root)

        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>) {
        adapter.setSubjects(timetable)
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
            mPresenter.swithDay(s)
        })
    }

    fun initSpinner(){

    }

}
