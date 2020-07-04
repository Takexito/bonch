package com.example.bonchapp.presentation.ui.authorization

import android.content.SharedPreferences

interface IAuthView {
    fun showError(message: String)
    fun getSharedPref(): SharedPreferences
    fun showProgressBar()
    fun hideProgressBar()
}