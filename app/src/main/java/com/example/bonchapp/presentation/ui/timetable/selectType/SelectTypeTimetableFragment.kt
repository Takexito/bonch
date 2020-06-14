<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/SelectTypeTimetableFragment.kt
package com.example.bonchapp.presentation.ui.timetable
=======
package com.example.bonchapp.presentation.ui.timetable.selectType
>>>>>>> timeTable:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/selectType/SelectTypeTimetableFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bonchapp.R
<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/SelectTypeTimetableFragment.kt
import com.example.bonchapp.presentation.ui.adapters.SelectGroupAdapter
=======
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.timetable.ITimetablePresenter
>>>>>>> timeTable:app/src/main/java/com/example/bonchapp/presentation/ui/timetable/selectType/SelectTypeTimetableFragment.kt
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
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
        val btn_select_group = root.findViewById<View>(R.id.btn_select_group)
        val btn_select_professor = root.findViewById<View>(R.id.btn_select_tutor)
        val btn_select_exam = root.findViewById<View>(R.id.btn_exams)
        val btn_select_elective = root.findViewById<View>(R.id.btn_elective)

        btn_select_group.setOnClickListener {
            presenter.switchType("group")

        }

        btn_select_professor.setOnClickListener {
            presenter.switchType("tutor")
        }

        btn_select_exam.setOnClickListener {
            presenter.switchType("exam")
        }

        btn_select_elective.setOnClickListener {
            presenter.switchType("user_id")
        }
    }
}
