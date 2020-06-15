package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.domain.interactors.timetable.ITimetableInteractor
import com.example.bonchapp.presentation.ui.timetable.main.ITimetableView
import com.example.bonchapp.router.MainRouter
import org.joda.time.DateTime
import com.example.bonchapp.domain.entities.RequestTimeTable
import org.joda.time.DateTimeConstants
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class TimetablePresenter @Inject constructor(
    private val interactor: ITimetableInteractor,
    val router: MainRouter
) : ITimetablePresenter {

    var currentDate = DateTime()
    val dtf = DateTimeFormat.forPattern("dd-MM-yyyy");

    private var name = "ИКПИ-84"
    private var type = "group"

    private lateinit var viewMain: ITimetableView


    override fun getAttachView(): ITimetableView {
        return viewMain
    }

    override fun attachView(viewMain: ITimetableView) {
        this.viewMain = viewMain
    }

    fun switchWeek(command: String) {
        if (command.equals("+")) {
            currentDate.plusWeeks(1)
        } else if (command.equals("-")) {
            currentDate.minusWeeks(1)
        }
        updateTimetable()
    }

    override fun switchWeek(dt: DateTime) {
        currentDate = dt
        updateTimetable()
    }


    override fun updateTimetable() {
        if (name != "") {
            val start: DateTime
            val end: DateTime

            start = currentDate.dayOfWeek().setCopy(DateTimeConstants.MONDAY)
            end = currentDate.dayOfWeek().setCopy(DateTimeConstants.SUNDAY)

            val body = RequestTimeTable(dtf.print(start), dtf.print(end), name, type)

            interactor.getTimetable(body,
                callback = {
                    viewMain.updateTimetable(it!!, currentDate)
                }
            )
        }
    }

    override fun switchType(type: String) {
        this.type = type

        viewMain.closeFragment()

        if (type == "group")
            viewMain.showSelectGroupFragment()
        else if (type == "tutor")
            viewMain.showSelectTutorFragment()
        else if (type == "exam")
            updateTimetable()
        else if (type == "user_id")
            updateTimetable()
    }

    override fun switchName(name:String){
        this.name = name
        viewMain.closeFragment()
        viewMain.showName(name)
        updateTimetable()
    }


}