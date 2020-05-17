package com.example.bonchapp.presentation.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.presentation.ui.adapters.SelectTutorAdapter

class SelectTutorFragment() : Fragment() {

    lateinit var tutorListAdapter: SelectTutorAdapter
    lateinit var arrSubjects: ArrayList<String>
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_select_group, container, false)

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(root)
        initSearchField(root)
    }

    private fun initRecyclerView(root: View) {
        tutorListAdapter =
            SelectTutorAdapter(root.context)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_selectGroup)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = tutorListAdapter

        //timeTable_recyclerView.apply {
        //  groupsListAdapter
        //}
    }

    private fun initSearchField(root: View) {
        val textSearch = root.findViewById<EditText>(R.id.search_field)
        textSearch.doOnTextChanged { text, start, count, after ->
            findInArray(text.toString())
        }
    }

    private fun findInArray(str: String) {

        if (str == "")
            tutorListAdapter.setGroups(arrSubjects)
        else {
            val arr: ArrayList<String> = arrayListOf()

            arrSubjects.forEach {
                if (it.contains(str, true)) {
                    arr.add(it)
                }
            }

            tutorListAdapter.setGroups(arr)
        }
    }
}
