package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.domain.interactors.timetable.ITimetableInteractor
import com.example.bonchapp.presentation.ui.timetable.selectGroup.ITimetableGroupView
import javax.inject.Inject

class TimetableGroupPresenter @Inject constructor(private val interactor: ITimetableInteractor): ITimetableGroupPresenter{

    private lateinit var viewMain: ITimetableGroupView

    override fun getAttachView(): ITimetableGroupView {
        return viewMain
    }

    override fun attachView(viewMain: ITimetableGroupView) {
        this.viewMain = viewMain
    }

    override fun loadList(){
        interactor.getGroupList(
            callback = {
                viewMain.setList(it!!)
            }
        )
    }
}