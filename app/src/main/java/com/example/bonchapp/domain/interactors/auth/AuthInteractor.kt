package com.example.bonchapp.domain.interactors.auth

import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.domain.repository.IAuthRepository
import com.example.bonchapp.router.User
import javax.inject.Inject

class AuthInteractor @Inject constructor(val repository: IAuthRepository) : IAuthInteractor {
    override fun login(
        user: User,
        callback: (data: Token?, errorMessage: String?) -> Unit
    ) {
        repository.logIn(user,
            callback = {
            if (it.isSuccessful) callback(it.body(), null)
            else {
                callback(null, it.errorBody().toString())
            }
        },
        callbackError = {
            callback(null, it)
        }
        )
    }
}