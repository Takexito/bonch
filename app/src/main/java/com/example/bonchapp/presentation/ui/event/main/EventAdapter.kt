package com.example.bonchapp.presentation.ui.event.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Event
import com.example.bonchapp.presentation.presenter.event.IEventPresenter
import kotlinx.android.synthetic.main.item_event.view.*
import javax.inject.Inject

class EventAdapter @Inject constructor(val presenter: IEventPresenter) :
        RecyclerView.Adapter<EventAdapter.ViewHolder>(), Filterable {

    private var data: ArrayList<Event>? = arrayListOf()
    private var newData: ArrayList<Event> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(data: List<Event>) {
        this.data = data as ArrayList<Event>
        newData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.apply {
            //presenter.view.setRecyclerVisible(true)
            titleEventView.text = data?.get(position)?.title ?: "Bad"
            dateEventView.text = data?.get(position)?.title ?: "Bad"

            setOnClickListener {
                presenter.onItemClick(data?.get(position)!!)
            }

//            favoriteEventButton.setOnClickListener {
//                data?.get(position)?.let { it1 -> {
//                    favoriteEventButton.setBackgroundColor(R.color.colorOrange)
//                    presenter.onItemLike(it1)
//                    }
//                }
//            }
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 1//TODO: Fix nullability
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResult = FilterResults()
                if (constraint.isNullOrBlank()) {
                    filterResult.count = newData.size
                    filterResult.values = newData
                    return filterResult
                }
                val result = data?.filter {
                    it.title.contains(constraint, true)
                }
                return filterResult.apply {
                    count = result?.size ?: 0
                    values = result
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                Log.d("ss", "ss")
                data = results?.values as ArrayList<Event>
                notifyDataSetChanged()
            }

        }
    }

}