package com.example.bonchapp.ui.timetable

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.OnTouchListener
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.adapters.DayTimeTableAdapter
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar.CalendarListener
import kotlinx.android.synthetic.main.fragment_timetable.view.*
import org.joda.time.DateTime


lateinit var mPresenter: PresenterTimeTable

class TimetableFragment : Fragment(), MainContract.ITimeTableView {

    lateinit var dayTimeTableAdapter: DayTimeTableAdapter
    lateinit var selectGroupFragment: SelectGroupFragment
    lateinit var selectTutorFragment: SelectTutorFragment


    //val mPresenter = PresenterTimeTable(this, this)

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_timetable, container, false)

        initRecyclerView()
        initCalender()
        //initSwitchTimetable(root)
        initSelectTypeTimetable()
        //initSwipes()

        mPresenter = PresenterTimeTable(this, this)

        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>, datesWeeks: List<String>) {
        dayTimeTableAdapter.setList(timetable, datesWeeks)
    }

    override fun showGroupsList(list: List<ArrayList<String>>) {
        selectGroupFragment.groupsListAdapter.setGroups(list)
        selectGroupFragment.arrSubjects = list

    }

    override fun showTutorsList(list: ArrayList<String>) {
        selectTutorFragment.tutorListAdapter.setGroups(list)
        selectTutorFragment.arrSubjects = list

    }

    override fun showSelectProfessorFragment() {
        selectTutorFragment = SelectTutorFragment()

        activity!!.supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment,
            selectTutorFragment, null
        ).addToBackStack(null).commit()

        //MainCoordinator.navigateToSelectGroup(this)
        mPresenter.updateTutorsList()
    }

    override fun showSelectGroupFragment() {
        selectGroupFragment = SelectGroupFragment()

        activity!!.supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment,
            selectGroupFragment, null
        ).addToBackStack(null).commit()

        //MainCoordinator.navigateToSelectGroup(this)
        mPresenter.updateGroupsList()
    }

    private fun initRecyclerView() {

        dayTimeTableAdapter = DayTimeTableAdapter(root.context, this)

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


        calendar.setCalendarListener(object : CalendarListener {
            override fun onDaySelect() {
                val day = calendar.selectedDay
                //val s: String = "${day?.day}-${1 + day?.month!!}-${day?.year}"
                //mPresenter.switchDayTimetable(s)
                val dt = DateTime(day!!.year, day.month + 1, day.day, 0, 0)

                val recyclerViewDay = root.findViewById<RecyclerView>(R.id.timeTable_recyclerView)

                if (dt.weekOfWeekyear != currentWeek) {
                    currentWeek = dt.dayOfWeek
                    mPresenter.switchDayTimetable(dt)
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

    /*private fun initSwitchTimetable(view: View) {
        val spinner = view.findViewById<TextView>(R.id.spinner)
        val groupName = view.findViewById<TextView>(R.id.groupName)
        val itemSwitchTimeTable = view.findViewById<View>(R.id.item_swithTimeTable)

        val btn_select_group = view.findViewById<View>(R.id.btn_select_group)
        val btn_select_professor = view.findViewById<View>(R.id.btn_select_tutor)


        spinner.setOnClickListener {
            itemSwitchTimeTable.setVisibility(View.VISIBLE)
        }

        groupName.setOnClickListener {
            itemSwitchTimeTable.setVisibility(View.INVISIBLE)
        }

        btn_select_group.setOnClickListener {
            mPresenter.switchTimetable("group")
            itemSwitchTimeTable.setVisibility(View.INVISIBLE)
        }

        btn_select_professor.setOnClickListener {
            mPresenter.switchTimetable("tutor")
            itemSwitchTimeTable.setVisibility(View.INVISIBLE)
        }
    }*/

    private fun initSelectTypeTimetable() {
        val button = root.findViewById<ImageView>(R.id.filter)
        button.setOnClickListener {
            //MainCoordinator.navigateToSelectTypeTimetable(this)
            activity!!.supportFragmentManager.beginTransaction()
                .add(SelectTypeTimetableFragment(), null).addToBackStack("1")
                .commit()
        }
    }

    private fun initSwipes() {

        val gdt = GestureDetector(context, GestureListener())

        val touchListener = OnTouchListener { v, event ->
            gdt.onTouchEvent(event)
        }

        val k = root.findViewById<View>(R.id.timeTable_recyclerView)

        k.setOnTouchListener(touchListener)
    }

    override fun setNameGroup(name: String) {
        val nameGroup = root.findViewById<TextView>(R.id.nameGroup)
        nameGroup.text = name
    }
}

private class GestureListener : GestureDetector.SimpleOnGestureListener() {
    private val SWIPE_MIN_DISTANCE = 12
    private val SWIPE_THRESHOLD_VELOCITY = 20


    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 != null && e2 != null) {
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                mPresenter.switchDayTimetable("-")
                return true; // справа налево
            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                mPresenter.switchDayTimetable("+")
                return true; // слева направо
            }
        }
        if (e1 != null && e2 != null) {

            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                return false; // снизу вверх
            } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                return false; // сверху вниз
            }
        }
        return false;

    }
}

