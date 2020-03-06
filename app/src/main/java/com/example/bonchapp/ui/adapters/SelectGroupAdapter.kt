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
    val imageSrc = itemView.findViewById<ImageView>(R.id.faculty_icon)
    val textName = itemView.findViewById<TextView>(R.id.item_group_nameGroup)

    lateinit var group:String

    fun bind(str: String, pos: Int) {

        group = str

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
            }/*
            group.indexOf("Санкт-Петербургский колледж телекоммуникаций СПбГУТ/") != -1 -> {
                textName.text =
                    group.replace("Санкт-Петербургский колледж телекоммуникаций СПбГУТ/", "")
                imageSrc.setImageResource(R.drawable.empty)
            }
            group.indexOf("Институт магистратуры/") != -1 -> {
                textName.text = group.replace("Институт магистратуры/", "")
                imageSrc.setImageResource(R.drawable.empty)
            }
            group.indexOf("ИНО/") != -1 -> {
                textName.text = group.replace("ИНО/", "")
                imageSrc.setImageResource(R.drawable.empty)
            }*/
            else -> {
                group = group.substring(group.indexOf("/")+1)
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


        itemView.setOnClickListener {
            mPresenter.switchGroup(group, "group")
        }
    }
}