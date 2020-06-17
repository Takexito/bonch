package com.example.bonchapp.presentation.ui.timetable.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetablePresenter
import org.joda.time.DateTime
import javax.inject.Inject

class TimetableViewPagerFragment(addWeeks: Int) : Fragment() {

    @Inject
    lateinit var presenter: ITimetablePresenter

    var myDate = setDate(addWeeks)

    lateinit var dayTimeTableAdapter: DayTimeTableAdapter

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_timetable_viewpager, container, false)

        return root
    }

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        updateTimetable()
    }

//    fun updateTimetable(timetable: ArrayList<SubjectDTO>, date: DateTime) {
//        dayTimeTableAdapter.setList(timetable, date)
//    }

    fun setDate(addWeeks: Int) :DateTime {
        var date = DateTime()
        date = date.plusWeeks(addWeeks)
        return date
    }

    fun updateTimetable() {
        presenter.updateTimetable(this, myDate,
            callback = {
                //fragment.updateTimetable(it!!, date)
                dayTimeTableAdapter.setList(it!!, myDate)
            }
        )
    }

    private fun initRecyclerView() {
        dayTimeTableAdapter =
            DayTimeTableAdapter(
                root.context,
                this
            )
        val recyclerViewDay = root.findViewById<RecyclerView>(R.id.timeTable_recyclerView)
        recyclerViewDay.layoutManager = LinearLayoutManager(root.context)
        recyclerViewDay.adapter = dayTimeTableAdapter
        recyclerViewDay.smoothScrollToPosition(0)
    }
}