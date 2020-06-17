package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.di.NetworkModule
import com.example.bonchapp.router.User
import com.example.bonchapp.data.network.NetworkServ
import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.domain.repository.IAuthRepository
import com.example.bonchapp.domain.util.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val networkService: NetworkService) : IAuthRepository {

    override fun logIn(user: User, callback: (response: Response<Token>) -> Unit, callbackError: (error: String) -> Unit) {
        Log.d("AuthRep", "request")
        networkService.getToken(body = user.auth).enqueue(object : Callback<Token> {
            override fun onResponse(call: Call<Token>, resp: Response<Token>) {
                Log.d("AuthRepository", user.auth.toString())
                Log.d("AuthRepository", resp.message())
                callback(resp)
            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("AuthRepository", t.localizedMessage ?: "Error!")
                callbackError(t.localizedMessage)
            }
        })
    }

}