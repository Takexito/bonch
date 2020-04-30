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
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import org.joda.time.DateTimeFieldType.dayOfWeek
import org.joda.time.Interval
import org.joda.time.ReadableInterval
import org.joda.time.format.DateTimeFormat
import org.xmlpull.v1.XmlPullParser

class TimetableAdapter(val context: Context, fragment: Fragment) :
    RecyclerView.Adapter<TimetablePostHolder>() {

    var subject = ArrayList<SubjectDTO>()

    val fragment = fragment

    lateinit var date: String

    fun setSubjects(subjectList: List<SubjectDTO>, date: String) {
        this.subject.clear()
        this.subject.addAll(subjectList)

        this.date = date

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
        holder.bind(subject[position], position, date)
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

    fun bind(subject: SubjectDTO, number: Int, date: String) {
        textTime.text = subject.time
        textName.text = subject.subject
        textType.text = subject.subject_type
        textProfessor.text = subject.tutor

        setGradient(number, checkActiveSubject(date, subject.time))

        if (subject.place != null) {
            val content = SpannableString(subject.place)
            content.setSpan(UnderlineSpan(), 0, content.length, 0)
            textCabinet.setText(content)
        } else
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

    fun setGradient(number: Int, b: Boolean) {
        val imageG = when (number) {
            0 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorOne),
                    imageGradient.resources.getColor(R.color.colorTwo)
                )
            )
            1 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorTwo),
                    imageGradient.resources.getColor(R.color.colorThree)
                )
            )
            2 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorThree),
                    imageGradient.resources.getColor(R.color.colorFour)
                )
            )
            3 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorFour),
                    imageGradient.resources.getColor(R.color.colorFive)
                )
            )
            4 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorFive),
                    imageGradient.resources.getColor(R.color.colorSix)
                )
            )
            5 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorSix),
                    imageGradient.resources.getColor(R.color.colorSeven)
                )
            )
            6 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorSeven),
                    imageGradient.resources.getColor(R.color.colorEight)
                )
            )
            7 -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    imageGradient.resources.getColor(R.color.colorEight),
                    imageGradient.resources.getColor(R.color.colorNine)
                )
            )

            else -> GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(Color.BLACK, Color.BLUE)
            )
        }

        imageG.shape = GradientDrawable.RECTANGLE
        imageG.gradientType = GradientDrawable.LINEAR_GRADIENT



        if (b)
            imageG.alpha = 200
        else
            imageG.alpha = 80



        imageGradient.setImageDrawable(imageG)

    }

    private fun checkActiveSubject(date: String, time: String): Boolean {
        if (date.equals(DateTimeFormat.forPattern("dd-MM-yyyy").print(DateTime()))) {

            val s1 = time.substring(0, 5)
            val s2 = time.substring(6, 11)

            val ss1 = date.substring(6, 10)
            val ss2 = date.substring(3, 5)
            val ss3 = date.substring(0, 2)
            val ss4 = s1.substring(0, 2)
            val ss5 = s1.substring(2, 4)


            val dt1 = DateTime(
                date.substring(6, 10).toInt(),
                date.substring(3, 5).toInt(),
                date.substring(0, 2).toInt(),
                s1.substring(0, 2).toInt(),
                s1.substring(3, 5).toInt()
            )
            val dt2 = DateTime(
                date.substring(6, 10).toInt(),
                date.substring(3, 5).toInt(),
                date.substring(0, 2).toInt(),
                s2.substring(0, 2).toInt(),
                s2.substring(3, 5).toInt()
            )

            if (DateTime.now() > dt1 && DateTime.now() < dt2)
                return true
            else
                return false
        } else
            return true
    }
}