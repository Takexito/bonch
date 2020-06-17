package com.example.bonchapp.presentation.ui.timetable.selectType

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetablePresenter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_type_timetable.*
import javax.inject.Inject

class SelectTypeTimetableFragment() : BottomSheetDialogFragment() {

    @Inject
    lateinit var presenter: ITimetablePresenter

    init {
        App.appComponent.inject(this)
    }


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
        //val btn_select_group = root.findViewById<View>(R.id.btn_select_group)
        //val btn_select_professor = root.findViewById<View>(R.id.btn_select_tutor)
        //val btn_select_exam = root.findViewById<View>(R.id.btn_exams)
        //val btn_select_elective = root.findViewById<View>(R.id.btn_elective)

        btn_select_group.setOnClickListener {
            presenter.switchType("group")

        }

        btn_select_tutor.setOnClickListener {
            presenter.switchType("tutor")
        }

        btn_exams.setOnClickListener {
            presenter.switchType("exam")
        }

        btn_elective.setOnClickListener {
            presenter.switchType("user_id")
        }
    }
}
