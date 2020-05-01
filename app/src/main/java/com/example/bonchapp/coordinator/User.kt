package com.example.bonchapp.coordinator

import com.example.bonchapp.model.pojo.Auth
import com.example.bonchapp.model.pojo.Token

object User {
    lateinit var auth: Auth
    lateinit var token: Token

    fun create(username: String, password: String): User{
        auth = Auth(username, password)
        return this
    }

    fun addToken(token: Token){
        this.token = token
    }

}