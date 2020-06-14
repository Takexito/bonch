package com.example.bonchapp.presentation.ui.timetable.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetablePresenter
import com.example.bonchapp.presentation.timetable.ui.ITimetableView
import com.example.bonchapp.presentation.ui.timetable.selectGroup.SelectGroupFragment
import com.example.bonchapp.presentation.ui.timetable.selectTutor.SelectTutorFragment
import com.example.bonchapp.presentation.ui.timetable.selectType.SelectTypeTimetableFragment
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import org.joda.time.DateTime
import javax.inject.Inject

class TimetableFragment : Fragment(), ITimetableView {

    @Inject
    lateinit var presenter: ITimetablePresenter
    lateinit var dayTimeTableAdapter: DayTimeTableAdapter
    lateinit var root: View

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_timetable, container, false)
        presenter.attachView(this)

        //initRecyclerView()
        //initCalender()
        //initSwitchTimetable(root)
        //initSelectTypeTimetable()
        //initSwipes()

        //mPresenter = PresenterTimeTable(this, this)

        //dayTimeTableAdapter = DayTimeTableAdapter(root.context,this)
        presenter.switchName("ИКПИ-84")
        presenter.updateTimetable()

        initRecyclerView()
        initCalender()
        initSelectTypeTimetable()

        return root
    }


    override fun updateTimetable(timetable: ArrayList<SubjectDTO>, date: DateTime) {
        dayTimeTableAdapter.setList(timetable, date)
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

    private fun initCalender() {

        val calendar = root.findViewById<CollapsibleCalendar>(R.id.calendar)

        val textMonth = root.findViewById<TextView>(R.id.month)
        textMonth.text =
            resources.getStringArray(R.array.Months)[(calendar.selectedDay?.month ?: 1) - 1]

        var currentWeek = DateTime.now().weekOfWeekyear


        calendar.setCalendarListener(object : CollapsibleCalendar.CalendarListener {
            override fun onDaySelect() {
                val day = calendar.selectedDay
                val dt = DateTime(day!!.year, day.month + 1, day.day, 0, 0)

                val recyclerViewDay = root.findViewById<RecyclerView>(R.id.timeTable_recyclerView)

                if (dt.weekOfWeekyear != currentWeek) {
                    currentWeek = dt.dayOfWeek
                    presenter.switchWeek(dt)
                }

                recyclerViewDay.scrollToPosition(dt.dayOfWeek - 1)
            }

            override fun onItemClick(view: View) {}
            override fun onClickListener() {
            }

            override fun onDataUpdate() {}
            override fun onDayChanged() {
            }

            override fun onMonthChange() {
                textMonth.text = resources.getStringArray(R.array.Months)[(calendar.month ?: 1)]
            }

            override fun onWeekChange(i: Int) {}
        })
    }

    private fun initSelectTypeTimetable() {
        val button = root.findViewById<ImageView>(R.id.filter)
        button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(SelectTypeTimetableFragment(), null).addToBackStack("1")
                .commit()
        }
    }

    override fun closeFragment() {
        requireActivity().supportFragmentManager.popBackStack()
        //activity?.onBackPressed()
    }

    override fun showSelectGroupFragment() {
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.mainTimetable,
            SelectGroupFragment(), null
        ).addToBackStack(null).commit()
    }

    override fun showSelectTutorFragment() {
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.mainTimetable,
            SelectTutorFragment(), null
        ).addToBackStack(null).commit()
    }


    override fun showName(s:String){
        val name = root.findViewById<TextView>(R.id.nameGroup)
        name.text = s
    }
}