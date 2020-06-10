package com.example.bonchapp.presentation.presenter.profile.mark

import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import com.example.bonchapp.presentation.ui.profile.mark.IProfileMarkView
import javax.inject.Inject

class ProfileMarkPresenter @Inject constructor(
    private val interactor: IProfileInteractor
) : IProfileMarkPresenter {

    private lateinit var viewMain: IProfileMarkView

    var list = arrayListOf<ArrayList<MarkDTO>>()

    override fun getAttachView(): IProfileMarkView {
        TODO("Not yet implemented")
    }

    override fun attachView(viewMain: IProfileMarkView) {
        this.viewMain = viewMain
    }

    override fun updateData() {
        if(list.isEmpty())
            interactor.getMark(
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

    fun sortArray(list: ArrayList<MarkDTO>): ArrayList<ArrayList<MarkDTO>> {
        val arr = arrayListOf<ArrayList<MarkDTO>>(ArrayList<MarkDTO>())


        val sortlist = list.sortedBy { it.semester }

        var sem = sortlist[0].semester


        sortlist.forEach {
            if (sem < it.semester) {
                arr.add(ArrayList<MarkDTO>())
                sem = it.semester
            }
            arr.last().add(it)
        }
        return arr
    }
}