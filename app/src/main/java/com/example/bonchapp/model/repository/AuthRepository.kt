package com.example.bonchapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bonchapp.model.network.NetworkService
import com.example.bonchapp.model.network.Service
import com.example.bonchapp.model.pojo.Auth
import com.example.bonchapp.model.pojo.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository() : IAuthRepository{

    override fun logIn(user: Auth, callback: (token: Token) -> Unit) {
        Log.d("AuthRep", "request")
        Service.TABLE_API.getToken(body = user).enqueue(object : Callback<Token> {
            override fun onResponse(call: Call<Token>, resp: Response<Token>) {
                Log.d("AuthRep", user.toString())
                if(resp.body() == null) callback(Token(resp.message()))
                else callback(resp.body()!!)
            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("EventRepository", t.localizedMessage ?: "Error!")            }
        })
    }

}