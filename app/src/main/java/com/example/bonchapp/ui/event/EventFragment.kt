package com.example.bonchapp.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.presenter.EventPresenter
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment : Fragment() {

    val presenter = EventPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setData()
        initRecycler()
    }

    private fun initRecycler() {
        eventRecyclerView.apply {
            adapter = EventAdapter(this@EventFragment)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
