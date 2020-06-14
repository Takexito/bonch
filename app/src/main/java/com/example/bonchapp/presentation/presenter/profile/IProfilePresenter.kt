package com.example.bonchapp.presentation.presenter.profile

import com.example.bonchapp.presentation.ui.profile.IProfileView
import com.example.bonchapp.presentation.ui.profile.elective.IProfileElectivesView

interface IProfilePresenter {
    fun getAttachView(): IProfileView
    fun attachView(viewMain: IProfileView)
    fun updateData()
}