package com.example.bonchapp.presentation.presenter.auth

import android.util.Log
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.router.User
import com.example.bonchapp.data.repository.AuthRepository
import com.example.bonchapp.presentation.ui.authorization.AuthFragment
import com.example.bonchapp.router.Constants
import com.example.bonchapp.router.MainCoordinator

class AuthPresenter(val fragment: AuthFragment) {

    private val repository = AuthRepository()

    fun signIn(email: String, pass: String) {

        if (email.isEmpty() or pass.isEmpty()) {
            fragment.onSignInError()
        } else {
            repository.logIn(User.create(email, pass)) {
                User.addToken(it)
                Log.d("Auth", "Token: ${it.value}")
                //Toast.makeText(fragment.context, it.value, Toast.LENGTH_LONG).show()
                saveTokenToPreference(it.value)
                MainCoordinator.navigateToTimetable(fragment)
            }
        }
    }

    private fun saveTokenToPreference(token: String){
        fragment.getSharedPreference().edit().putString(Constants.TOKEN, token).apply()
    }
}