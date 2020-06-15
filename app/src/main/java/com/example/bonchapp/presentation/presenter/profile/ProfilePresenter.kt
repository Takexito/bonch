package com.example.bonchapp.presentation.presenter.profile

import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import com.example.bonchapp.presentation.ui.profile.IProfileView
import com.example.bonchapp.presentation.ui.profile.elective.IProfileElectivesView
import javax.inject.Inject

class ProfilePresenter @Inject constructor(private val interactor: IProfileInteractor) :
    IProfilePresenter {

    private lateinit var viewMain: IProfileView


    override fun getAttachView(): IProfileView {
        TODO("Not yet implemented")
    }

    override fun attachView(viewMain: IProfileView) {
        this.viewMain = viewMain
    }

    override fun updateData() {
        interactor.getUserInfo(
            callback = {
                if (it != null) {
                    viewMain.setData(it)
                }
            }
        )
    }
}