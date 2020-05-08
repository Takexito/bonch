package com.example.bonchapp.ui.profile.electives

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
import com.example.bonchapp.ui.adapters.ElectiveAdapter
import com.example.bonchapp.ui.adapters.MarkAdapter

class ProfileElectivesFragment : Fragment() {

    lateinit var electiveAdapter: ElectiveAdapter

    lateinit var root: View

    lateinit var list: ArrayList<ElectiveDTO>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_profile_electives, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("Debbik", "onViewCreated")
        initRV(list)
    }

    fun initRV(list: ArrayList<ElectiveDTO>) {
        electiveAdapter = ElectiveAdapter(root.context, this, list)
        val recyclerViewDay = root.findViewById<RecyclerView>(R.id.profileRV)
        recyclerViewDay.layoutManager = LinearLayoutManager(root.context)
        recyclerViewDay.adapter = electiveAdapter
    }

    fun setArray(list: ArrayList<ElectiveDTO>) {
        this.list = list
    }

    override fun onStart() {
        super.onStart()
        Log.d("Debbik", "Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debbik", "Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Debbik", "Stop")

    }

    override fun onPause() {
        super.onPause()
        Log.d("Debbik", "Pause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debbik", "Destroy")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Debbik", "DestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Debbik", "Detach")
    }
}