package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.ElectiveDTO

class ElectiveAdapter(
    val context: Context,
    val fragment: Fragment,
    val subject: ArrayList<ElectiveDTO>
) :
    RecyclerView.Adapter<ElectivePostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectivePostHolder {
        return ElectivePostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_electives, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = subject.size

    override fun onBindViewHolder(holder: ElectivePostHolder, position: Int) {
        holder.bind(subject[position], position == 0)
    }

}

class ElectivePostHolder(itemView: View, val fragment: Fragment) :
    RecyclerView.ViewHolder(itemView) {

    val name = itemView.findViewById<TextView>(R.id.profile_subject_name)
    val status = itemView.findViewById<TextView>(R.id.profile_status)
    val mark = itemView.findViewById<TextView>(R.id.profile_mark)


    fun bind(subject: ElectiveDTO, first: Boolean) {
        if (first){
            val divider = itemView.findViewById<View>(R.id.divider)
            divider.visibility = View.INVISIBLE
        }


        name.text = subject.subject
        status.text = subject.status
        mark.text = subject.mark
    }
}