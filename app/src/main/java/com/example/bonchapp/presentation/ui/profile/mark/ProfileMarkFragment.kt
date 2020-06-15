package com.example.bonchapp.presentation.ui.profile.mark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.profile.mark.IProfileMarkPresenter
import com.example.bonchapp.presentation.ui.profile.debt.DebtAdapter
import javax.inject.Inject

class ProfileMarkFragment : Fragment(),
    IProfileMarkView {

    @Inject
    lateinit var presenter: IProfileMarkPresenter

    lateinit var adapter: MarkAdapter

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_profile_recordbook, container, false)

        return root
    }

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
        presenter.attachView(this)
        presenter.updateData()
    }

    fun initRV() {
        adapter = MarkAdapter(
            root.context,
            this
        )
        val recyclerViewDay = root.findViewById<RecyclerView>(R.id.profileRV)
        recyclerViewDay.layoutManager = LinearLayoutManager(root.context)
        recyclerViewDay.adapter = adapter
    }

    override fun setData(list: ArrayList<ArrayList<MarkDTO>>) {
        adapter.setData(list)
    }

    override fun hideRV(b:Boolean){
        root.findViewById<View>(R.id.profilEmptyImage).visibility = if(b) View.VISIBLE else View.INVISIBLE
    }
}