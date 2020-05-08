package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.MarkDTO

class MarkAdapter(
    val context: Context,
    val fragment: Fragment,
    val subject: ArrayList<ArrayList<MarkDTO>>
) :
    RecyclerView.Adapter<MarkPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkPostHolder {
        return MarkPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_profile_debt, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = subject.size

    override fun onBindViewHolder(holder: MarkPostHolder, position: Int) {
        holder.bind(subject[position], subject.size == position - 1)
    }

}

class MarkPostHolder(itemView: View, val fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {

    val course = itemView.findViewById<TextView>(R.id.textProfileCourse)

    fun bind(subjects: ArrayList<MarkDTO>, last: Boolean) {
        val markCourseAdapter = MarkCourseAdapter(itemView.context, fragment, subjects)
        val recyclerViewDay = itemView.findViewById<RecyclerView>(R.id.profile_mark_rv)
        recyclerViewDay.layoutManager = LinearLayoutManager(itemView.context)
        recyclerViewDay.adapter = markCourseAdapter

        course.text = "${subjects[0].course} ${subjects[0].semester}"
    }
}