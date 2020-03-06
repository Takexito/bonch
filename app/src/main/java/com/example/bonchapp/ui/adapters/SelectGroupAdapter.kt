package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presenter.PresenterTimeTable
import com.example.bonchapp.ui.timetable.mPresenter

class SelectGroupAdapter(val context: Context, type: Int) :
    RecyclerView.Adapter<SelectGroupPostHolder>() {

    var subject = ArrayList<String>()
    val type = type

    fun setGroups(groupList: List<String>) {
        this.subject.clear()
        this.subject.addAll(groupList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectGroupPostHolder {
        return SelectGroupPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_group, parent, false), type
        )
    }

    override fun getItemCount(): Int = subject.size


    override fun onBindViewHolder(holder: SelectGroupPostHolder, position: Int) {
        holder.bind(subject[position], position)
    }

}

class SelectGroupPostHolder(itemView: View, type: Int) : RecyclerView.ViewHolder(itemView) {
    val imageSrc = itemView.findViewById<ImageView>(R.id.faculty_icon)
    val textName = itemView.findViewById<TextView>(R.id.item_group_nameGroup)
    val type = type

    lateinit var group: String

    fun bind(str: String, pos: Int) {

        group = str
        if (type == 0)
            when {
                group.indexOf("РТС/") != -1 -> {
                    group = group.replace("РТС/", "")
                    imageSrc.setImageResource(R.drawable.rts)
                }
                group.indexOf("ИС и Т/") != -1 -> {
                    group = group.replace("ИС и Т/", "")
                    imageSrc.setImageResource(R.drawable.isit)
                }
                group.indexOf("ИКСС/") != -1 -> {
                    group = group.replace("ИКСС/", "")
                    imageSrc.setImageResource(R.drawable.ikss_pushka)
                }
                group.indexOf("ЦЭУБИ/") != -1 -> {
                    group = group.replace("ЦЭУБИ/", "")
                    imageSrc.setImageResource(R.drawable.ceubi)
                }
                group.indexOf("ГФ/") != -1 -> {
                    group = group.replace("ГФ/", "")
                    imageSrc.setImageResource(R.drawable.gf)
                }
                else -> {
                    group = group.substring(group.indexOf("/") + 1)
                    imageSrc.setImageResource(R.drawable.empty)
                }
            }
        textName.text = group

        val background: Int

        if (pos % 2 != 0)
            background = itemView.resources.getColor(R.color.colorItemGrey)
        else
            background = itemView.resources.getColor(R.color.colorItemWhite)

        itemView.setBackgroundColor(background)


        var typeS = ""

        if (type == 0)
            typeS = "group"
        else typeS = "tutor"

        itemView.setOnClickListener {
            mPresenter.switchGroup(group, typeS)
        }
    }
}