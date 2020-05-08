package com.example.bonchapp.ui.profile.recordbook

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.ElectiveDTO
import com.example.bonchapp.model.pojo.MarkDTO
import com.example.bonchapp.ui.adapters.MarkAdapter

class ProfileRecordbookFragment : Fragment() {

    lateinit var debtRecordAdapter: MarkAdapter
    lateinit var root: View
    lateinit var list: ArrayList<ArrayList<MarkDTO>>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        root = inflater.inflate(R.layout.fragment_profile_recordbook, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (this::list.isInitialized)
            initRV(list)
    }


    fun initRV(list: ArrayList<ArrayList<MarkDTO>>) {
        debtRecordAdapter = MarkAdapter(root.context, this, list)
        val recyclerViewDay = root.findViewById<RecyclerView>(R.id.profileRV)
        recyclerViewDay.layoutManager = LinearLayoutManager(root.context)
        recyclerViewDay.adapter = debtRecordAdapter
    }

    fun setArray(list: ArrayList<MarkDTO>) {
        if (this::root.isInitialized) {
            this.list = sortArray(list)

            initRV(sortArray(list))
        }
    }

    fun sortArray(list: ArrayList<MarkDTO>): ArrayList<ArrayList<MarkDTO>> {
        val arr = arrayListOf<ArrayList<MarkDTO>>(ArrayList<MarkDTO>())

        var sem = 1

        val sortlist = list.sortedBy { it.semester }

        sortlist.forEach {
            if (sem < it.semester) {
                arr.add(ArrayList<MarkDTO>())
                sem = it.semester
            }
            arr.last().add(it)
        }
        return arr
    }


}