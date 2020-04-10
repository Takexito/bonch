package com.example.bonchapp.ui.authorization

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerVH>() {
    inner class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return if (viewType == 0) PagerVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.auth_page_1,
                parent,
                false
            )
        )
        else PagerVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.auth_page_2,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {

    }
}