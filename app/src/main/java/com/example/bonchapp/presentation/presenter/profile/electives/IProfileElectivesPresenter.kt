package com.example.bonchapp.presentation.presenter.profile.electives

import com.example.bonchapp.presentation.ui.profile.elective.IProfileElectivesView

interface IProfileElectivesPresenter {
    fun getAttachView(): IProfileElectivesView
    fun attachView(viewMain: IProfileElectivesView)
    fun updateData()
}