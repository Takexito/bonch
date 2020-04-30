package com.example.bonchapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.pojo.Auth
import com.example.bonchapp.model.pojo.Token

interface IAuthRepository {
    fun logIn(user: Auth, callback: (token: Token) -> Unit)
}