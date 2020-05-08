package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.MarkDTO

class MarkCourseAdapter(
    val context: Context,
    val fragment: Fragment,
    val subject: ArrayList<MarkDTO>
) :
    RecyclerView.Adapter<MarkCoursePostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkCoursePostHolder {
        return MarkCoursePostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_profile_element_debt, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = subject.size

    override fun onBindViewHolder(holder: MarkCoursePostHolder, position: Int) {
        holder.bind(subject[position], subject.size == position - 1)
    }

}

class MarkCoursePostHolder(itemView: View, val fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {
    val divider = itemView.findViewById<View>(R.id.divider)

    val name = itemView.findViewById<TextView>(R.id.profile_subject_name)
    val status = itemView.findViewById<TextView>(R.id.profile_status)


    fun bind(subject: MarkDTO, last: Boolean) {
        if(last)
            divider.visibility = View.INVISIBLE
        else
            divider.visibility = View.VISIBLE

        name.text = subject.subject
        status.text = subject.mark
    }
}