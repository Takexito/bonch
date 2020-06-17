package com.example.bonchapp.domain.repository

import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages

interface IMessageRepository {
    var messages: Messages?
    var inMessages: Messages?
    var outMessages: Messages?

    fun getMessage(callback: (data: Messages?, error: String?) -> Unit)
    fun sendMessage(message: Message, callback: (error: String?) -> Unit)
    fun deleteMessage(message: Message, callback: (error: String?) -> Unit)
}