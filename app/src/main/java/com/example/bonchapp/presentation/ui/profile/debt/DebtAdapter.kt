package com.example.bonchapp.presentation.ui.profile.debt

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

class DebtAdapter(
    val context: Context,
    val fragment: Fragment
) :
    RecyclerView.Adapter<DebtPostHolder>() {

    val list = arrayListOf<ArrayList<DebtDTO>>()

    fun setData(list: ArrayList<ArrayList<DebtDTO>>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtPostHolder {
        return DebtPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_profile_debt, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DebtPostHolder, position: Int) {
        holder.bind(list[position], list.size == position - 1)
    }

}

class DebtPostHolder(itemView: View, val fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {

    val course = itemView.findViewById<TextView>(R.id.textProfileCourse)

    fun bind(subjects: ArrayList<DebtDTO>, last: Boolean) {
        val markCourseAdapter = DebtCourseAdapter(itemView.context, fragment, subjects)
        val recyclerViewDay = itemView.findViewById<RecyclerView>(R.id.profile_mark_rv)
        recyclerViewDay.layoutManager = LinearLayoutManager(itemView.context)
        recyclerViewDay.adapter = markCourseAdapter

        course.text = "${subjects[0].course} курс ${subjects[0].semester} семестр"
    }
}
