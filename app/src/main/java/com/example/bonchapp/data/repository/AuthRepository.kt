package com.example.bonchapp.data.repository

import android.util.Log
import com.example.bonchapp.router.User
import com.example.bonchapp.data.network.NetworkServ
import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.domain.repository.IAuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository : IAuthRepository {

    override fun logIn(user: User, callback: (token: Token) -> Unit) {
        Log.d("AuthRep", "request")
        NetworkServ.TABLE_API.getToken(body = user.auth).enqueue(object : Callback<Token> {
            override fun onResponse(call: Call<Token>, resp: Response<Token>) {
                Log.d("AuthRep", user.auth.toString())
                Log.d("AuthRep", resp.message())
                if (resp.body() != null) callback(resp.body()!!)
            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("AuthRepository", t.localizedMessage ?: "Error!")
            }
        })
    }

}