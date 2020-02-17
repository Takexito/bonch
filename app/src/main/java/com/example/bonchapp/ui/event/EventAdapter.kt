package com.example.bonchapp.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.model.pojo.Event
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(
    private val data: ArrayList<Event>,
    private val eventFragment: EventFragment
) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            titleEventView.text = data[position].title
            subTitleEventView.text = data[position].subTitle
            setOnClickListener {
                eventFragment.presenter.onItemClick(position)
            }
        }
    }
}