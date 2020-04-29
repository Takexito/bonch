package com.example.bonchapp.presenter

import android.widget.Toast
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.pojo.Auth
import com.example.bonchapp.model.repository.AuthRepository
import com.example.bonchapp.ui.authorization.AuthFragment

class AuthPresenter(val fragment: AuthFragment) {

    private val repository = AuthRepository()

    fun signIn(email: String, pass: String) {
        if (email.isEmpty() or pass.isEmpty()) {
            fragment.onSignInError()
        } else {
            repository.logIn(Auth(email, pass)) {
                Toast.makeText(fragment.context, it, Toast.LENGTH_LONG).show()
                MainCoordinator.navigateToTimetable(fragment)
            }
        }
    }
}