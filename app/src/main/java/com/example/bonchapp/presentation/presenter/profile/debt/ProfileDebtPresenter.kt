package com.example.bonchapp.presentation.presenter.profile.debt

import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import com.example.bonchapp.presentation.ui.profile.debt.IProfileDebtView
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject

class ProfileDebtPresenter @Inject constructor(
    private val interactor: IProfileInteractor
) : IProfileDebtPresenter {

    var list = arrayListOf<ArrayList<DebtDTO>>()

    private lateinit var viewMain: IProfileDebtView

    override fun getAttachView(): IProfileDebtView {
        return viewMain
    }

    override fun attachView(viewMain: IProfileDebtView) {
        this.viewMain = viewMain
    }

    override fun updateData() {
        if(list.isEmpty())
        interactor.getDebt(
            callback = {
                if (it!!.isNotEmpty()) {
                    list = sortArray(it!!)
                    viewMain.setData(list)
                    viewMain.hideRV(false)
                } else
                    viewMain.hideRV(true)
            }
        )
        else{
            viewMain.setData(list)
            viewMain.hideRV(false)
        }
    }

    fun sortArray(list: ArrayList<DebtDTO>): ArrayList<ArrayList<DebtDTO>> {
        val arr = arrayListOf<ArrayList<DebtDTO>>(ArrayList<DebtDTO>())


        val sortlist = list.sortedBy { it.semester }

        var sem = sortlist[0].semester


        sortlist.forEach {
            if (sem < it.semester) {
                arr.add(ArrayList<DebtDTO>())
                sem = it.semester
            }
            arr.last().add(it)
        }
        return arr
    }
}