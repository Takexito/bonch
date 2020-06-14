package com.example.bonchapp.presentation.presenter.profile.mark

import com.example.bonchapp.presentation.ui.profile.mark.IProfileMarkView


interface IProfileMarkPresenter {
    fun getAttachView(): IProfileMarkView
    fun attachView(viewMain: IProfileMarkView)
    fun updateData()
}