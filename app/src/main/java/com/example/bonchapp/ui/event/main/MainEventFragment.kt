package com.example.bonchapp.ui.event.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.presenter.event.EventPresenter
import com.example.bonchapp.ui.event.IEventView
import kotlinx.android.synthetic.main.fragment_main_event.*


class MainEventFragment : Fragment(), IEventView{

    val presenter = EventPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onStart()
        initUi()
    }

    private fun initUi() {
        initRecycler()
        initSearch()
        initFab()
    }

    private fun initRecycler() {
        eventRecyclerView.apply {
            adapter = EventAdapter(presenter)
            layoutManager = LinearLayoutManager(context)
        }

        presenter.testData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                (eventRecyclerView.adapter as EventAdapter).setData(
                    presenter.testData.value ?: arrayListOf()
                )
                eventRecyclerView.adapter?.notifyDataSetChanged()
            })
    }

    private fun initSearch() {
        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.onSearchQueryUpdate(eventRecyclerView, newText)
                return true
            }
        })
    }

    private fun initFab(){
        addEventFab.setOnClickListener{
            presenter.onFabClick()
        }
    }

    override fun getFragmentContext(): Context {
        return context!!
    }

    override fun getFragment(): Fragment {
        return this
    }

    override fun setRecyclerVisible(isVisible: Boolean) {
        if(isVisible)
            eventRecyclerView.visibility = View.VISIBLE
        else
            eventRecyclerView.visibility = View.GONE

    }

    override fun getRecyclerFilter(): Filter {
        return (eventRecyclerView.adapter as Filterable).filter

    }
}
