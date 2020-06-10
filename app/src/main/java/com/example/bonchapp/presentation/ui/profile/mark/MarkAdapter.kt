package com.example.bonchapp.presentation.ui.profile.mark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.presentation.ui.profile.debt.DebtCourseAdapter

class MarkAdapter(
    val context: Context,
    val fragment: Fragment
) :
    RecyclerView.Adapter<MarkPostHolder>() {

    val list = arrayListOf<ArrayList<MarkDTO>>()

    fun setData(list: ArrayList<ArrayList<MarkDTO>>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkPostHolder {
        return MarkPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_profile_debt, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MarkPostHolder, position: Int) {
        holder.bind(list[position], list.size == position - 1)
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

        course.text = "${subjects[0].course} курс ${subjects[0].semester} семестр"
    }
}
