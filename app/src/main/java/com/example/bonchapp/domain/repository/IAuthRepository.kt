package com.example.bonchapp.domain.repository

import com.example.bonchapp.router.User
import com.example.bonchapp.domain.entities.Token

interface IAuthRepository {
    fun logIn(user: User, callback: (token: Token) -> Unit)
}