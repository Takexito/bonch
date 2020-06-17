package com.example.bonchapp.presentation.ui.message

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class FilesRecyclerItemTouchHelper(adapter: MessageAdapter): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val mAdapter = adapter

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        mAdapter.onItemDismiss(viewHolder.adapterPosition)
    }
}