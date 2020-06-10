package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.db.MessageStorage
import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages
import com.example.bonchapp.domain.repository.IMessageRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MessageRepository @Inject constructor(private val networkService: NetworkService): IMessageRepository {

    override var messages: Messages? = null
    override var inMessages: Messages? = null
    override var outMessages: Messages? = null

    override fun getMessage(callback: (data: Messages?, error: String?) -> Unit) {

        Log.d("MessageRepository", "request")
        networkService.getMessages().enqueue(object : Callback<ArrayList<Message>> {
            override fun onResponse(call: Call<ArrayList<Message>>, resp: Response<ArrayList<Message>>) {

                Log.d("MessageRepository", "Good")
                messages = Messages(resp.body()?: arrayListOf(Message("Error", "Error")))

                if(resp.isSuccessful)
                    callback(messages, null)
                else
                    callback(getLocalMessage(), resp.errorBody()?.string())
            }

            override fun onFailure(call: Call<ArrayList<Message>>, t: Throwable) {
                Log.d("MessageRepository", t.localizedMessage ?: "Error!")

                callback(getLocalMessage(), t.localizedMessage)
            }
        })
    }

    private fun getLocalMessage(): Messages{
        return Messages(MessageStorage.messages)
    }

    override fun sendMessage(message: Message, callback: (error: String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun deleteMessage(message: Message, callback: (error: String?) -> Unit) {
        TODO("Not yet implemented")
    }
}