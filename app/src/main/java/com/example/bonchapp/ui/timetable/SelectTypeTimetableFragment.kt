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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_type_timetable, container, false)

        return root
    }
}