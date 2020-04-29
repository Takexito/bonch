package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.ui.adapters.SelectGroupAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectTypeTimetableFragment() : BottomSheetDialogFragment() {
lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_type_timetable, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnInit()
    }

    private fun btnInit(){
        val btn_select_group = root.findViewById<View>(R.id.btn_select_group)
        val btn_select_professor = root.findViewById<View>(R.id.btn_select_tutor)
        val btn_select_exam = root.findViewById<View>(R.id.btn_exams)

        btn_select_group.setOnClickListener {
            mPresenter.switchTimetable("group")

        }

        btn_select_professor.setOnClickListener {
            mPresenter.switchTimetable("tutor")
        }

        btn_select_exam.setOnClickListener {
            mPresenter.switchTimetable("exam")
        }
    }
}