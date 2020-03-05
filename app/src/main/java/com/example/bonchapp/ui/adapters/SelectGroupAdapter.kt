package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.timetable.mPresenter

class SelectGroupAdapter(val context: Context) : RecyclerView.Adapter<SelectGroupPostHolder>() {

    var subject = ArrayList<String>()

    fun setGroups(groupList: List<String>) {
        this.subject.clear()
        this.subject.addAll(groupList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectGroupPostHolder {
        return SelectGroupPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_group, parent, false)
        )
    }

    override fun getItemCount(): Int = subject.size


    override fun onBindViewHolder(holder: SelectGroupPostHolder, position: Int) {
        holder.bind(subject[position], position)
    }

}

class SelectGroupPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //val imageSrc = itemView.findViewById<TextView>(R.id.subject_time)

    lateinit var group: String
    val textName = itemView.findViewById<TextView>(R.id.item_group_nameGroup)

    fun bind(group: String, pos: Int) {
        this.group = group
        textName.text = group

        val background: Int

        if (pos % 2 != 0)
            background = itemView.resources.getColor(R.color.colorItemGrey)
        else
            background = itemView.resources.getColor(R.color.colorItemWhite)

        itemView.setBackgroundColor(background)


        itemView.setOnClickListener {
            mPresenter.switchGroup(group, "group")
        }

    }

}