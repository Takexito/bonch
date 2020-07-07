package com.example.bonchapp.presentation.ui.event.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.event.IMainEventPresenter
import kotlinx.android.synthetic.main.fragment_main_event.*
import kotlinx.android.synthetic.main.fragment_storage.*
import javax.inject.Inject


class MainEventFragment : Fragment(), IMainEventView {

    @Inject
    lateinit var presenter: IMainEventPresenter
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
        eventRecyclerView.addVeiledItems(10)
        eventRecyclerView.veil()
        presenter.firstLoad()

        initUi()
    }

    override fun updateRecycler(data: List<Event>){
        eventRecyclerView.unVeil()
        Log.d("MainEventFragment", "Recycler unVeil")
        eventAdapter.apply {
            setData(data)
            notifyDataSetChanged()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun addToFavorite(event: Event) {

    }

    override fun setRecyclerVisible(isVisible: Boolean) {
        //if(isVisible)
           // eventRecyclerView.visibility = View.VISIBLE
        //else
            //eventRecyclerView.visibility = View.GONE

    }

    override fun getRecyclerFilter(): Filter {
        return (eventRecyclerView.getRecyclerView().adapter as Filterable).filter

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

            setAdapter(eventAdapter)
            setLayoutManager(LinearLayoutManager(context))
        }
        Log.d("MainEventFragment", "Recycler Veil")


    }

    private fun initSearch() {
        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.onSearchQueryUpdate(eventRecyclerView.getRecyclerView(), newText)
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
