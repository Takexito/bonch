package com.example.bonchapp.presentation.ui.adapters

import android.content.Context
import android.os.Build
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import org.joda.time.DateTime
import org.w3c.dom.Text
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.ArrayList

class DayTimeTableAdapter(val context: Context, fragment: Fragment) :
    RecyclerView.Adapter<DayTimetablePostHolder>() {

    val fragment = fragment

    //val list = ArrayList<ArrayList<SubjectDTO>>()
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

    fun setList(subjectList: List<SubjectDTO>, datesWeeks: List<String>) {
        this.datesWeeks.clear()
        this.datesWeeks.addAll(datesWeeks)



        for (i in 0..6)
            list[i].clear()

        subjectList.forEach {

            val s = it.date
            val dt = DateTime(
                s.substring(0, 4).toInt(),
                s.substring(5, 7).toInt(),
                s.substring(8, 10).toInt(),
                0,
                0
            )

            list[dt.dayOfWeek - 1].add(it)
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
        if(!datesWeeks.isEmpty())
        holder.bind(list[position], datesWeeks[position], position)
    }
}

class DayTimetablePostHolder(itemView: View, fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {
    val timeTableAdapter =
        TimetableAdapter(
            itemView.context,
            fragment
        )
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

    fun bind(arrayList: ArrayList<SubjectDTO>, date:String, number: Int) {

        if (arrayList.isEmpty()) {
            withoutClasses.visibility = View.VISIBLE
            recyclerViewDay.visibility = View.INVISIBLE
        }
        else {
            withoutClasses.visibility = View.INVISIBLE
            recyclerViewDay.visibility = View.VISIBLE

            recyclerViewDay.layoutManager = LinearLayoutManager(itemView.context)
            recyclerViewDay.adapter = timeTableAdapter
            timeTableAdapter.setSubjects(arrayList, date)
        }

        viewDate.text = "${dayOfWeek[number]} ${date.substring(0, 5)}"


    }
}