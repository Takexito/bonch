package com.example.bonchapp.presenter

import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.ui.authorization.AuthFragment

class AuthPresenter(val fragment: AuthFragment) {

    fun signIn(email: String, pass: String) {
        if (email.isEmpty() or pass.isEmpty()) {
            fragment.onSignInError()
        } else {
            MainCoordinator.navigateToTimetable(fragment)
        }
    }
}