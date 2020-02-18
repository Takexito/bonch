package com.example.bonchapp.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(private val eventFragment: EventFragment) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private val data = eventFragment.presenter.testData

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 1//TODO: Fix nullability
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onDataChange(holder.itemView, position)
    }

    private fun onDataChange(itemView: View, position: Int) {
        eventFragment.presenter.testData.observe(
            eventFragment.viewLifecycleOwner,
            androidx.lifecycle.Observer {
                itemView.apply {
                    titleEventView.text = it[position]
                    subTitleEventView.text = it[position]
                    setOnClickListener {
                        eventFragment.presenter.onItemClick(position)
                    }
                }
            })
    }
}