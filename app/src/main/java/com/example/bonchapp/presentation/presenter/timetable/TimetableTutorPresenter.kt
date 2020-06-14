package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.domain.interactors.timetable.ITimetableInteractor
import com.example.bonchapp.presentation.ui.timetable.selectGroup.ITimetableGroupView
import com.example.bonchapp.presentation.ui.timetable.selectTutor.ITimetableTutorView
import javax.inject.Inject

class TimetableTutorPresenter @Inject constructor(private val interactor: ITimetableInteractor): ITimetableTutorPresenter{

    private lateinit var viewMain: ITimetableTutorView

    override fun getAttachView(): ITimetableTutorView {
        return viewMain
    }

    override fun attachView(viewMain: ITimetableTutorView) {
        this.viewMain = viewMain
    }

    override fun loadList(){
        interactor.getTutorList(
            callback = {
                viewMain.setList(it!!)
            }
        )
    }
}