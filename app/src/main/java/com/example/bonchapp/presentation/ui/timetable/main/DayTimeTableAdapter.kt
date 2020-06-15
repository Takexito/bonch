package com.example.bonchapp.presentation.ui.timetable.main

import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import org.joda.time.format.DateTimeFormat
import kotlin.collections.ArrayList

class DayTimeTableAdapter(val context: Context, fragment: Fragment) :
    RecyclerView.Adapter<DayTimetablePostHolder>() {

    val dtf = DateTimeFormat.forPattern("dd-MM-yyyy");


    val fragment = fragment

    val list = arrayListOf(
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>(),
        ArrayList<SubjectDTO>()
    )

    val datesWeeks: ArrayList<String> = arrayListOf()

    fun receiveDatesWeek(date:DateTime){

        val datesWeeks = arrayListOf<String>(
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.MONDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.TUESDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.WEDNESDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.THURSDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.FRIDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.SATURDAY)),
            dtf.print(date.dayOfWeek().setCopy(DateTimeConstants.SUNDAY))
        )

        this.datesWeeks.clear()
        this.datesWeeks.addAll(datesWeeks)
    }

    fun setList(subjectList: List<SubjectDTO>, date:DateTime) {
        receiveDatesWeek(date)

        for (i in 0..6)
            list[i].clear()


        subjectList.forEach {
                if (it.date != "") {
                    var s = it.date
                    //if(s.length<22) s = "0$s"
                    val dt = DateTime.parse(it.date)
//                    val dt = DateTime(
//                        s.substring(0, 4).toInt(),
//                        s.substring(5, 7).toInt(),
//                        s.substring(8, 10).toInt(),
//                        0,
//                        0
//                    )

                    list[dt.dayOfWeek - 1].add(it)
                }

        }

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayTimetablePostHolder {
        return DayTimetablePostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_day, parent, false), fragment
        )
    }

    override fun getItemCount() = 7

    override fun onBindViewHolder(holder: DayTimetablePostHolder, position: Int) {
        if (!datesWeeks.isEmpty())
            holder.bind(list[position], datesWeeks[position], position)
    }
}

class DayTimetablePostHolder(itemView: View, val fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {
    val recyclerViewDay = itemView.findViewById<RecyclerView>(R.id.dayRecyclerView)
    val withoutClasses = itemView.findViewById<LinearLayout>(R.id.without_classes)

    val dayOfWeek = arrayListOf<String>(
        "Понедельник",
        "Вторник",
        "Среда",
        "Четверг",
        "Пятница",
        "Суббота",
        "Воскресенье"
    )

    val viewDate = itemView.findViewById<TextView>(R.id.dateTimeTable)

    fun bind(arrayList: ArrayList<SubjectDTO>, date: String, number: Int) {

        if (arrayList.isEmpty()) {
            withoutClasses.visibility = View.VISIBLE
            recyclerViewDay.visibility = View.INVISIBLE
            withoutClasses.layoutParams.height = ActionBar.LayoutParams.MATCH_PARENT

            recyclerViewDay.layoutManager = LinearLayoutManager(itemView.context)
            recyclerViewDay.adapter =
                TimetableAdapter(
                    itemView.context,
                    fragment,
                    arrayListOf(),
                    date
                ) //Pass an empty array so that the element does not stretch

        } else {
            withoutClasses.visibility = View.INVISIBLE
            recyclerViewDay.visibility = View.VISIBLE
            withoutClasses.layoutParams.height = 1

            arrayList.forEach {
                if (it.pair.length > 1) {
                    it.pair = it.pair.substring(1)
                }
            }

            val sortArrayList = arrayList.sortedBy { it.pair }


            //timeTableAdapter.setSubjects(sortArrayList, date)
            recyclerViewDay.layoutManager = LinearLayoutManager(itemView.context)
            recyclerViewDay.adapter =
                TimetableAdapter(
                    itemView.context,
                    fragment,
                    sortArrayList,
                    date
                )

        }

        viewDate.text = "${dayOfWeek[number]} ${date.substring(0, 5)}"
    }
}