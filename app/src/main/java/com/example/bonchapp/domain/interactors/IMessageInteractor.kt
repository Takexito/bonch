package com.example.bonchapp.domain.interactors

import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages

interface IMessageInteractor {
    fun getAllMessage(callback: (data: Messages) -> Unit, errorCallback: (error: String) -> Unit)
    fun sendMessage(message: Message, callback: () -> Unit, errorCallback: (error: String) -> Unit)
    fun deleteMessage(
        message: Message,
        callback: () -> Unit,
        errorCallback: (error: String) -> Unit
    )

    fun getInMessages(): Messages
    fun getOutMessages(): Messages
}
