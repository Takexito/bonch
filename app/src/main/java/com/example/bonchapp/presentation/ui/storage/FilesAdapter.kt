package com.example.bonchapp.presentation.ui.storage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import kotlinx.android.synthetic.main.item_file.view.*

class FilesAdapter(val context: Context, var data: MutableList<String>): RecyclerView.Adapter<FilesAdapter.FilesHolder>() {

    inner class FilesHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_file, parent, false)
        return FilesHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FilesHolder, position: Int) {
        holder.itemView.run {
            item_title.text = data[position]
        }
    }

    fun onItemDismiss(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }
}