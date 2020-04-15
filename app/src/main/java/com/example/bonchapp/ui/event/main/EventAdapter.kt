package com.example.bonchapp.ui.event.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.presenter.event.IEventPresenter
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(private val presenter: IEventPresenter) :
        RecyclerView.Adapter<EventAdapter.ViewHolder>(), Filterable {

    private var data: ArrayList<String>? = arrayListOf()
    private var newData: ArrayList<String> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(data: List<String>) {
        this.data = data as ArrayList<String>
        newData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.apply {
            presenter.view.setRecyclerVisible(true)
            titleEventView.text = data?.get(position) ?: "Bad"
            dateEventView.text = data?.get(position) ?: "Bad"

            setOnClickListener {
                presenter.onItemClick(position)
            }

            favoriteEventButton.setOnClickListener {
                data?.get(position)?.let { it1 -> {
                    favoriteEventButton.setBackgroundColor(R.color.colorOrange)
                    //presenter.onItemLike(it1) TODO: FIX ME
                    }
                }
            }
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
                    it.contains(constraint, true)
                }
                return filterResult.apply {
                    count = result?.size ?: 0
                    values = result
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                Log.d("ss", "ss")
                data = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }

}