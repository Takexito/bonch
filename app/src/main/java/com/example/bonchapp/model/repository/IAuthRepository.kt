package com.example.bonchapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.pojo.Auth

interface IAuthRepository {
    fun logIn(user: Auth, callback: (token: String) -> Unit)
}