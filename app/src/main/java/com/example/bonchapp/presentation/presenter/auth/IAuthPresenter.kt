package com.example.bonchapp.presentation.presenter.auth

import com.example.bonchapp.presentation.ui.authorization.IAuthView

interface IAuthPresenter {
    fun getAttachView(): IAuthView
    fun attachView(view: IAuthView)
    fun onSignInClick(email: String, pass: String)
}