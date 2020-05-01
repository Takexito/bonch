package com.example.bonchapp.ui.event.my

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.get
import com.example.bonchapp.R
import com.kizitonwose.calendarview.model.*
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import kotlinx.android.synthetic.main.calendar_day.view.*
import kotlinx.android.synthetic.main.calendar_day_legend.*
import kotlinx.android.synthetic.main.calendar_header.view.*
import kotlinx.android.synthetic.main.fragment_application_event.*
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.Month
import org.threeten.bp.YearMonth
import org.threeten.bp.temporal.WeekFields
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ApplicationEventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ApplicationEventFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var currDay: LocalDate = LocalDate.now()
    var pickDay: LocalDate? = null
    var pickDayView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_application_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initCalendar()
    }

    private fun initCalendar(){

        calendarView.monthHeaderBinder = object : MonthHeaderFooterBinder<MonthViewContainer>{
            override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                container.textView.text = Month.values()[month.month - 1].toString()

            }

            override fun create(view: View) = MonthViewContainer(view)

        }
        calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                container.textView.text = day.date.dayOfMonth.toString()
                if (day.owner == DayOwner.THIS_MONTH) {
                    container.textView.setTextColor(resources.getColor(R.color.colorOrange))
                } else {
                    container.textView.setTextColor(Color.WHITE)
                }

                if(currDay == day.date) container.textView.setBackgroundResource(R.color.colorPrimary)


            }
        }

        calendarView.inDateStyle = InDateStyle.ALL_MONTHS
        calendarView.outDateStyle = OutDateStyle.NONE
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = DayOfWeek.MONDAY
        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        calendarView.scrollToMonth(currentMonth)

    }

    fun pickDate(day: CalendarDay, view: View){
        if(pickDay == null) {
            view.setBackgroundResource(R.color.colorAccent)
            pickDay = day.date
            calendarView.notifyDateChanged(day.date)
        }
        else {
            pickDayView?.background = null
            pickDay = day.date
            view.setBackgroundResource(R.color.colorAccent)
            calendarView.notifyDateChanged(day.date)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ApplicationEventFragment()
    }
    inner class DayViewContainer(view: View) : ViewContainer(view) {
        lateinit var day: CalendarDay
        val textView = view.calendarDayText
        init {
            view.setOnClickListener {
                pickDate(day, it)
            }
        }


    }
}



class MonthViewContainer(view: View) : ViewContainer(view) {
    val textView = view.monthView
}