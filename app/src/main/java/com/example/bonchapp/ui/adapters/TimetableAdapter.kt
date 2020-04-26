package com.example.bonchapp.ui.adapters

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.pojo.SubjectDTO
import org.xmlpull.v1.XmlPullParser

var g:Int = 0

class TimetableAdapter(val context: Context, fragment: Fragment) :
    RecyclerView.Adapter<TimetablePostHolder>() {

    var subject = ArrayList<SubjectDTO>()

    val fragment = fragment

    fun setSubjects(subjectList: List<SubjectDTO>) {
        this.subject.clear()
        this.subject.addAll(subjectList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetablePostHolder {
        return TimetablePostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_subject, parent, false), fragment
        )
    }

    override fun getItemCount(): Int = subject.size

    override fun onBindViewHolder(holder: TimetablePostHolder, position: Int) {
        holder.bind(subject[position], position)
    }

}

class TimetablePostHolder(itemView: View, fragment: Fragment) : RecyclerView.ViewHolder(itemView) {
    val textTime = itemView.findViewById<TextView>(R.id.subject_time)
    val textName = itemView.findViewById<TextView>(R.id.subject_name)
    val textType = itemView.findViewById<TextView>(R.id.subject_type)
    val textProfessor = itemView.findViewById<TextView>(R.id.subject_professor)
    val textCabinet = itemView.findViewById<TextView>(R.id.subject_cabinet)

    val imageGradient = itemView.findViewById<ImageView>(R.id.gradient_timetable)

    val fragment = fragment

    fun bind(subject: SubjectDTO, number:Int) {
        textTime.text = subject.time
        textName.text = subject.subject
        textType.text = subject.subject_type
        textProfessor.text = subject.tutor

        g++
        Log.d("BIND", "BINDING $g")

        setGradient(number)

        if (subject.place != null) {
            val content = SpannableString(subject.place)
            content.setSpan(UnderlineSpan(), 0, content.length, 0)
            textCabinet.setText(content)
        }
        else
            textCabinet.setText("")

        textCabinet.setOnClickListener {
            MainCoordinator.showCabinetInNavigator(fragment, stringer(subject.place))
        }
    }

    fun stringer(str: String): String {
        if (str.indexOf("Б22") != -1) {
            return str.replace("; Б22", "")
        } else if (str.indexOf("БМ20") != -1) {
            return str.replace("; БМ20", "")
        }
        return ""
    }

    fun setGradient(number: Int){
        val imageG = when(number){
            0  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorOne), imageGradient.resources.getColor(R.color.colorTwo)))
            1  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorTwo), imageGradient.resources.getColor(R.color.colorThree)))
            2  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorThree), imageGradient.resources.getColor(R.color.colorFour)))
            3  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorFour), imageGradient.resources.getColor(R.color.colorFive)))
            4  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorFive), imageGradient.resources.getColor(R.color.colorSix)))
            5  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorSix), imageGradient.resources.getColor(R.color.colorSeven)))
            6  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorSeven), imageGradient.resources.getColor(R.color.colorEight)))
            7  -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(imageGradient.resources.getColor(R.color.colorEight), imageGradient.resources.getColor(R.color.colorNine)))

            else -> GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(Color.BLACK, Color.BLUE))
        }

        imageG.shape = GradientDrawable.RECTANGLE
        imageG.gradientType = GradientDrawable.LINEAR_GRADIENT

        imageGradient.setImageDrawable(imageG)

    }
}