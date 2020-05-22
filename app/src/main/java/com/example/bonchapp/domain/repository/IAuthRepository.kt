package com.example.bonchapp.domain.repository

import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.router.User
import retrofit2.Response

interface IAuthRepository {
    fun logIn(user: User, callback: (resp: Response<Token>) -> Unit, callbackError: (error: String) -> Unit)
}