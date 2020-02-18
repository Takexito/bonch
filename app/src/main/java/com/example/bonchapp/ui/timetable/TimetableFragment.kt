package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bonchapp.MainContract
import com.example.bonchapp.R
import com.example.bonchapp.pojo.SubjectDTO

class TimetableFragment : Fragment(), MainContract.View {

    private lateinit var timetableViewModel: TimetableViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_timetable, container, false)


        return root
    }

    override fun showTimetable(timetable: List<SubjectDTO>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
