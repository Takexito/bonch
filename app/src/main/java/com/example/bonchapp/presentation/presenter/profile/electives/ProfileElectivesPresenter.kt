package com.example.bonchapp.presentation.presenter.profile.electives

import com.example.bonchapp.domain.entities.ElectiveDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import com.example.bonchapp.presentation.presenter.profile.mark.IProfileMarkPresenter
import com.example.bonchapp.presentation.ui.profile.debt.IProfileDebtView
import com.example.bonchapp.presentation.ui.profile.elective.IProfileElectivesView
import com.example.bonchapp.presentation.ui.profile.mark.IProfileMarkView
import javax.inject.Inject

class ProfileElectivesPresenter @Inject constructor(
    private val interactor: IProfileInteractor
) : IProfileElectivesPresenter {

    private lateinit var viewMain: IProfileElectivesView

    var list = arrayListOf<ElectiveDTO>()


    override fun getAttachView(): IProfileElectivesView {
        TODO("Not yet implemented")
    }

    override fun attachView(viewMain: IProfileElectivesView) {
        this.viewMain = viewMain
    }

    override fun updateData() {
        if(list.isEmpty())
            interactor.getElectives(
                callback = {
                    if (it!!.isNotEmpty()) {
                        list = it!!
                        viewMain.setData(list)
                        viewMain.hideImg(false)
                    } else
                        viewMain.hideImg(true)
                }
            )
        else{
            viewMain.setData(list)
            viewMain.hideImg(false)
        }

    }
}