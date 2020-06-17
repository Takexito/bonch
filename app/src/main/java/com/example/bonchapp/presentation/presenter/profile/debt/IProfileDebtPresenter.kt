package com.example.bonchapp.presentation.presenter.profile.debt

import com.example.bonchapp.presentation.ui.profile.debt.IProfileDebtView

interface IProfileDebtPresenter {
    fun getAttachView(): IProfileDebtView
    fun attachView(viewMain: IProfileDebtView)
    fun updateData()
}