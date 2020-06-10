package com.example.bonchapp.presentation.ui.message

import androidx.lifecycle.LifecycleOwner
import com.example.bonchapp.domain.entities.Message
import com.example.bonchapp.domain.entities.Messages

interface IMessageView {

    fun getLifecycleOwner(): LifecycleOwner
    fun updateRecycler(data: Messages)
    fun showError(message: String)

}
