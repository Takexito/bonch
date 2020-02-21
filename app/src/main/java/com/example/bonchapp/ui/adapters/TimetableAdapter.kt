package com.example.bonchapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO

class TimetableAdapter(val context: Context) : RecyclerView.Adapter<TimetablePostHolder>() {

    var subject = ArrayList<SubjectDTO>()

    fun setSubjects(subjectList: List<SubjectDTO>){
        this.subject.clear()
        this.subject.addAll(subjectList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetablePostHolder {
        return TimetablePostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_subject, parent, false)
        )
    }

    override fun getItemCount(): Int = subject.size

    override fun onBindViewHolder(holder: TimetablePostHolder, position: Int) {
        holder.bind(subject[position])
    }

}

class TimetablePostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textTime = itemView.findViewById<TextView>(R.id.subject_time)
    val textName = itemView.findViewById<TextView>(R.id.subject_name)
    val textType = itemView.findViewById<TextView>(R.id.subject_type)
    val textProfessor = itemView.findViewById<TextView>(R.id.subject_professor)
    val textCabinet = itemView.findViewById<TextView>(R.id.subject_cabinet)

    fun bind(subject: SubjectDTO) {
        textTime.text = subject.time
        textName.text = subject.subject
        textType.text = subject.subjec_type
        textProfessor.text = subject.tutor
        textCabinet.text = subject.cabinet
    }
}