package com.example.bonchapp.data.db

import com.example.bonchapp.domain.entities.Message

object MessageStorage {
    val messages: ArrayList<Message> = arrayListOf()


    fun setAllMessages(messages: ArrayList<Message>){
        this.messages.clear()
        messages.forEach{
            this.messages.add(it)
        }
    }

    init {
        messages.addAll(arrayListOf(
            Message("Message 0", "Sub Message 0", text = "Text Message 0"),
            Message("Message 1", "Sub Message 1", text = "Text Message 1"),
            Message("Message 2", "Sub Message 2", text = "Text Message 2"),
            Message("Message 3", "Sub Message 3", text = "Text Message 3")

        ))
    }
}