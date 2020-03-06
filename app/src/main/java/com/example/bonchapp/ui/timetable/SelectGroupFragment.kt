package com.example.bonchapp.ui.timetable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.ui.adapters.SelectGroupAdapter

class SelectGroupFragment(type: Int) : Fragment() {

    lateinit var groupsListAdapter: SelectGroupAdapter
    lateinit var arrSubjects: List<String>
    val type = type

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View

        if (type == 0) root = inflater.inflate(R.layout.fragment_select_group, container, false)
        else root = inflater.inflate(R.layout.fragment_select_tutor, container, false)

        initRecyclerView(root)
        initSearchField(root)

        return root

    }

    fun initRecyclerView(root: View) {
        groupsListAdapter = SelectGroupAdapter(root.context, type)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_selectGroup)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = groupsListAdapter
    }

    fun initSearchField(root: View) {
        val textSearch = root.findViewById<EditText>(R.id.search_field)
        textSearch.doOnTextChanged { text, start, count, after ->
            findInArray(text.toString())
        }
    }

    fun findInArray(str: String) {

        if (str == "")
            groupsListAdapter.setGroups(arrSubjects)
        else {

            var arr: ArrayList<String> = arrayListOf()
            for (i in arrSubjects) {
                if (i.contains(str, true)) {
                    arr.add(i)
                }
            }
            groupsListAdapter.setGroups(arr)
        }
    }
}