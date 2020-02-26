package com.example.bonchapp.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import kotlinx.android.synthetic.main.fragment_event.*
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            eventFragment.eventRecyclerView?.visibility = View.VISIBLE
            titleEventView.text = data.value?.get(position) ?: "Bad"
            dateEventView.text = data.value?.get(position) ?: "Bad"

            setOnClickListener {
                eventFragment.presenter.onItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 1//TODO: Fix nullability
    }

}