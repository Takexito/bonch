package com.example.bonchapp.presenter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.bonchapp.coordinator.Keys
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.coordinator.User
import com.example.bonchapp.model.pojo.Token
import com.example.bonchapp.model.repository.AuthRepository
import com.example.bonchapp.ui.authorization.AuthFragment

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
        fragment.getSharedPreference().edit().putString(Keys.TOKEN, token).apply()
    }
}