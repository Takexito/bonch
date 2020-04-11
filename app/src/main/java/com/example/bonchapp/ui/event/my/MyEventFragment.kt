package com.example.bonchapp.ui.event.my

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bonchapp.R
import com.example.bonchapp.presenter.event.MyEventPresenter
import com.example.bonchapp.ui.event.IEventView
import com.example.bonchapp.ui.event.main.EventAdapter
import kotlinx.android.synthetic.main.fragment_main_event.*
import kotlinx.android.synthetic.main.fragment_my_event.*


class MyEventFragment : Fragment(), IEventView {
    val presenter = MyEventPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_event, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart()
        init()
    }

    private fun init(){
        initRecycler()
    }

    private fun initRecycler(){
            myEventRecycler.apply {
                adapter = EventAdapter(presenter)
                layoutManager = LinearLayoutManager(context)
            }

            presenter.testData.observe(
                viewLifecycleOwner,
                androidx.lifecycle.Observer {
                    (myEventRecycler.adapter as EventAdapter).setData(
                        presenter.testData.value ?: arrayListOf()
                    )
                    myEventRecycler.adapter?.notifyDataSetChanged()
                })
    }

    override fun getFragmentContext(): Context {
        return context!!
    }

    override fun getFragment(): Fragment {
        return this
    }

    override fun setRecyclerVisible(isVisible: Boolean) {
        if(isVisible)
            myEventRecycler.visibility = View.VISIBLE
        else
            myEventRecycler.visibility = View.GONE
    }

    override fun getRecyclerFilter(): Filter {
        return (myEventRecycler.adapter as Filterable).filter
    }
}