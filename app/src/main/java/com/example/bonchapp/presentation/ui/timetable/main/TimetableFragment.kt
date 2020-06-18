package com.example.bonchapp.presentation.ui.timetable.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetablePresenter
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_timetable.*
import org.joda.time.DateTime
import javax.inject.Inject

class TimetableFragment : Fragment(), ITimetableView {

    @Inject
    lateinit var presenter: ITimetablePresenter
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var root: View

    init {
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_timetable, container, false)
        presenter.attachView(this)

        initCalender()
        initSelectTypeTimetable()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().nav_view.visibility = View.VISIBLE

        presenter.firstLoad()
        initViewPager()
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerAdapter(this)

        viewPager2.adapter = viewPagerAdapter
        viewPager2.setCurrentItem(500, false)
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
                }

                recyclerViewDay.scrollToPosition(dt.dayOfWeek - 1)
            }

            override fun onItemClick(v: View) {}
            override fun onClickListener() {
            }

            override fun onDataUpdate() {}
            override fun onDayChanged() {
            }

            override fun onMonthChange() {
                textMonth.text = resources.getStringArray(R.array.Months)[(calendar.month ?: 1)]
            }

            override fun onWeekChange(position: Int) {}
        })
    }

    private fun initSelectTypeTimetable() {
        val button = root.findViewById<ImageView>(R.id.filter)
        button.setOnClickListener {
            presenter.navigateToSelectType()
        }
    }

    override fun hideKeyboard() {
        val context: Context = requireContext().applicationContext
        val imm =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(root.windowToken, 0)
    }

    override fun showName(s: String) {
        val name = root.findViewById<TextView>(R.id.nameGroup)
        name.text = s
    }
}