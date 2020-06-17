package com.example.bonchapp.domain.interactors

import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages
import com.example.bonchapp.domain.repository.IMessageRepository
import javax.inject.Inject

class MessageInteractor @Inject constructor(var repository: IMessageRepository): IMessageInteractor {


    override fun getAllMessage(callback: (data: Messages) -> Unit,
                               errorCallback: (error: String) -> Unit) {
        repository.getMessage { data, error ->
            if (data != null) {

                val inMessages = Messages(arrayListOf())
                val outMessages = Messages(arrayListOf())
                data.messages.forEach {
                    if(it.type == "in") inMessages.messages.add(it)
                    else outMessages.messages.add(it)
                }

                repository.inMessages = inMessages
                repository.outMessages = outMessages
                callback(data)
                //TODO("Move to another thread")
            }
            if (error != null) errorCallback(error)
        }
    }


    override fun sendMessage(message: Message,
                             callback: () -> Unit,
                             errorCallback: (error: String) -> Unit) {
        repository.sendMessage(message){
            if (it != null) errorCallback(it)
            else callback()
            //TODO("Create Message Update on device")
        }
    }

    override fun deleteMessage(
        message: Message,
        callback: () -> Unit,
        errorCallback: (error: String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getInMessages(): Messages {
        return repository.inMessages ?: Messages(arrayListOf(Message(teacher = "error!")))
    }

    override fun getOutMessages(): Messages {
        return repository.outMessages ?: Messages(arrayListOf(Message(teacher = "error!")))
    }
}