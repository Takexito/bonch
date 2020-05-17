package com.example.bonchapp.presentation.ui.event.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.event.EventPresenter
import com.example.bonchapp.presentation.presenter.event.IEventPresenter
import com.example.bonchapp.presentation.ui.event.IEventView
import kotlinx.android.synthetic.main.fragment_main_event.*
import javax.inject.Inject


class MainEventFragment : Fragment(), IEventView {

    @Inject
    lateinit var presenter: IEventPresenter
    @Inject lateinit var eventAdapter: EventAdapter

    init {
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.attachView(this)
        return inflater.inflate(R.layout.fragment_main_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.firstLoad()
        initUi()
    }

    override fun updateRecycler(data: List<Event>){
        eventAdapter.apply {
            setData(arrayListOf("")) //TODO: FIX ME
            notifyDataSetChanged()
        }
    }

    override fun getFragmentContext(): Context {
        return requireContext()
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

    override fun getLifecycleOwner(): LifecycleOwner {
        return viewLifecycleOwner
    }

    private fun initUi() {
        initRecycler()
        initSearch()
        //initFab()
    }

    private fun initRecycler() {
        eventRecyclerView.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context)
        }

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

//    private fun initFab(){
//        addEventFab.setOnClickListener{
//            //presenter.onFabClick()
//            presenter.firstLoad()
//            Log.d("Fragment", "click")
//        }
//    }

}
