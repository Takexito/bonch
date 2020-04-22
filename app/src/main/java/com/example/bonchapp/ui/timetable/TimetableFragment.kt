package com.example.bonchapp.ui.timetable

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.adapters.TimetableAdapter
import com.example.bonchapp.ui.event.FullEventFragment
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.shrikanthravi.collapsiblecalendarview.data.Day
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar.CalendarListener
import kotlinx.android.synthetic.main.fragment_timetable.*


lateinit var mPresenter: PresenterTimeTable

class TimetableFragment : Fragment(), MainContract.ITimeTableView {

    lateinit var timeTableAdapter: TimetableAdapter
    lateinit var selectGroupFragment: SelectGroupFragment

    //val mPresenter = PresenterTimeTable(this, this)

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_timetable, container, false)

        initRecyclerView(root)
        initCalender(root)
        initSwitchTimetable(root)
        initSelectTypeTimetable()

        mPresenter = PresenterTimeTable(this, this)

        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>) {
        timeTableAdapter.setSubjects(timetable)
    }

    override fun showGroupsList(list: List<String>) {
        selectGroupFragment.groupsListAdapter.setGroups(list)
        selectGroupFragment.arrSubjects = list

    }

    override fun showSelectProfessorFragment() {
        selectGroupFragment = SelectGroupFragment(1)

        activity!!.supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment,
            selectGroupFragment, null
        ).addToBackStack(null).commit()

        //MainCoordinator.navigateToSelectGroup(this)
        mPresenter.updateTutorsList()
    }

    override fun showSelectGroupFragment() {
        selectGroupFragment = SelectGroupFragment(0)

        activity!!.supportFragmentManager.beginTransaction().add(
            R.id.nav_host_fragment,
            selectGroupFragment, null
        ).addToBackStack(null).commit()

        //MainCoordinator.navigateToSelectGroup(this)
        mPresenter.updateGroupsList()
    }

    private fun initRecyclerView(view: View) {
        timeTableAdapter = TimetableAdapter(view.context, this)
        //val recyclerViewDay = view.findViewById<RecyclerView>(R.id.timeTable_recyclerView)
        //recyclerViewDay.layoutManager = LinearLayoutManager(view.context)
        //recyclerViewDay.adapter = timeTableAdapter

        timeTable_recyclerView.apply {
            timeTableAdapter
        }
    }

    private fun initCalender(view: View) {
        /*val calendar = view.findViewById<MaterialCalendarView>(R.id.calendar)
        calendar.setTopbarVisible(false)

        val textMonth = view.findViewById<TextView>(R.id.month)

        val cur = CurrentDayDecorator(activity, CalendarDay.today(), calendar.selectedDate)
        calendar.addDecorators(cur)

        calendar.setOnDateChangedListener(OnDateSelectedListener { widget, date, selected ->
            val s: String = "${date.year}-${date.month}-${date.day}"
            mPresenter.switchDayTimetable(s)

            cur.myDay = CalendarDay.from(2020,3,22)
            cur.shouldDecorate(CalendarDay.from(2020,3,22))
        })

        textMonth.text = resources.getStringArray(R.array.Months)[calendar.currentDate.month - 1]

        calendar.setOnMonthChangedListener { widget, date ->
            textMonth.text =
                resources.getStringArray(R.array.Months)[calendar.currentDate.month - 1]

        }

        calendar.setSelectedDate(CalendarDay.today())
         */

        val calendar = view.findViewById<CollapsibleCalendar>(R.id.calendar)

        //calendar.firstDayOfWeek = 1

        val textMonth = view.findViewById<TextView>(R.id.month)
        textMonth.text = resources.getStringArray(R.array.Months)[(calendar.selectedDay?.month ?: 1) - 1]


        calendar.setCalendarListener(object : CalendarListener {
            override fun onDaySelect() {
                val day = calendar.selectedDay
                val s: String = "${day?.year}-${1 + day?.month!!}-${day?.day}"
            mPresenter.switchDayTimetable(s)
            }

            override fun onItemClick(view: View) {}
            override fun onClickListener() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    private fun initSwitchTimetable(view: View) {
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
    }

    private fun initSelectTypeTimetable() {
        val button = root.findViewById<ImageView>(R.id.filter)
        button.setOnClickListener {
            //MainCoordinator.navigateToSelectTypeTimetable(this)
            activity!!.supportFragmentManager.beginTransaction().add(SelectTypeTimetableFragment(), null)
                .commit()
        }
    }

    override fun setMissingGroupVisibility(b: Boolean) {
        val r = root.findViewById<LinearLayout>(R.id.missing_teacher)

        if (b)
            r.setVisibility(View.VISIBLE)
        else
            r.setVisibility(View.INVISIBLE)

    }

    override fun setWithoutClassesVisibility(b: Boolean) {
        val r = root.findViewById<LinearLayout>(R.id.without_classes)

        if (b)
            r.setVisibility(View.VISIBLE)
        else
            r.setVisibility(View.INVISIBLE)

    }

    override fun setNameGroup(name: String) {
        val groupName = root.findViewById<TextView>(R.id.groupName)
        groupName.text = name

        val spinner_groupName = root.findViewById<TextView>(R.id.spinner)
        spinner_groupName.text = name
    }
}

class CurrentDayDecorator(context: Activity?, currentDay: CalendarDay, selectedDay: CalendarDay?) :
    DayViewDecorator {
    private val drawable: Drawable?
    var myDay = currentDay
    val sel = selectedDay
    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == myDay
    }

    override fun decorate(view: DayViewFacade) {
        view.setSelectionDrawable(drawable!!)
    }

    init {
// You can set background for Decorator via drawable here
        drawable = ContextCompat.getDrawable(context!!, R.drawable.selectedday_outline)
    }
}
