package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.GroupDTO
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.adapters.DayTimeTableAdapter
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar.CalendarListener
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

        initRecyclerView(root)
        initCalender(root)
        //initSwitchTimetable(root)
        initSelectTypeTimetable()

        mPresenter = PresenterTimeTable(this, this)

        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>) {
        dayTimeTableAdapter.setList(timetable)
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

    private fun initRecyclerView(view: View) {

        dayTimeTableAdapter = DayTimeTableAdapter(view.context, this)

        val recyclerViewDay = view.findViewById<RecyclerView>(R.id.timeTable_recyclerView)
        recyclerViewDay.layoutManager = LinearLayoutManager(view.context)
        recyclerViewDay.adapter = dayTimeTableAdapter

        recyclerViewDay.smoothScrollToPosition(5)
    }

    private fun initCalender(view: View) {

        val calendar = view.findViewById<CollapsibleCalendar>(R.id.calendar)

        val textMonth = view.findViewById<TextView>(R.id.month)
        textMonth.text =
            resources.getStringArray(R.array.Months)[(calendar.selectedDay?.month ?: 1) - 1]

        var currentWeek = DateTime.now().weekOfWeekyear


        calendar.setCalendarListener(object : CalendarListener {
            override fun onDaySelect() {
                val day = calendar.selectedDay
                //val s: String = "${day?.day}-${1 + day?.month!!}-${day?.year}"
                //mPresenter.switchDayTimetable(s)
                val dt = DateTime(day!!.year, day.month + 1, day.day, 0, 0)

                val recyclerViewDay = view.findViewById<RecyclerView>(R.id.timeTable_recyclerView)

                if(dt.weekOfWeekyear != currentWeek){
                    currentWeek = dt.dayOfWeek
                    mPresenter.switchDayTimetable(dt)
                }

                recyclerViewDay.scrollToPosition(dt.dayOfWeek-1)
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
        val nameGroup = root.findViewById<TextView>(R.id.nameGroup)
        nameGroup.text = name
    }
}
