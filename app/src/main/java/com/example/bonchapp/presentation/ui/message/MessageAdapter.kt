package com.example.bonchapp.presentation.ui.message

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages
import com.example.bonchapp.presentation.presenter.message.IMessagePresenter
import kotlinx.android.synthetic.main.item_message.view.*
import javax.inject.Inject


class MessageAdapter @Inject constructor(val presenter: IMessagePresenter) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    var isOut = true

    private var data: Messages? = Messages(arrayListOf())
   // private var newData: ArrayList<Message> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(data: Messages) {
        this.data = data
       // newData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val message = data?.messages?.get(position) ?: Message()

        holder.itemView.apply {
            message_sender.text = message.teacher
            message_subject.text = message.theme
            message_text.text = message.text
            setOnClickListener {
                presenter.onItemClick(message)
            }

            if(message.isRead == false) message_card.background = resources.getDrawable(R.color.colorOrange)

        }


    }

    fun onItemDismiss(position: Int) {
        //data?.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return data?.messages?.size ?: 1
    }


}