package com.example.bonchapp.domain.interactors.auth

import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.router.User
import retrofit2.Response

interface IAuthInteractor {
    fun login(user: User, callback: (data: Token?, errorMessage: String?) -> Unit)
}