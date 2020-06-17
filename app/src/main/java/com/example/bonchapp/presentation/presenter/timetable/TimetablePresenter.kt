package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.domain.interactors.timetable.ITimetableInteractor
import com.example.bonchapp.presentation.ui.timetable.main.ITimetableView
import com.example.bonchapp.router.MainRouter
import org.joda.time.DateTime
import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import org.joda.time.DateTimeConstants
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class TimetablePresenter @Inject constructor(
    private val interactor: ITimetableInteractor, private val profileInteractor: IProfileInteractor,
    val router: MainRouter
) : ITimetablePresenter {

    var currentDate = DateTime()
    val dtf = DateTimeFormat.forPattern("dd-MM-yyyy");

    private var originalName = ""
    private var originalType = "group"
    private var name = ""
    private var type = "group"

    private lateinit var viewMain: ITimetableView

    var btn_origin = false


    override fun getAttachView(): ITimetableView {
        return viewMain
    }

    override fun attachView(viewMain: ITimetableView) {
        this.viewMain = viewMain
    }

    fun getIserInfo() {
        profileInteractor.getUserInfo(
            callback = {
                if (it != null) {
                    originalName = it.group
                    switchName(it.group)
                    loadTimetable()
                }
            }
        )
    }

    override fun firstLoad(){
        loadTimetable()
        viewMain.showName(name)
    }

    fun switchWeek(command: String) {
        if (command.equals("+")) {
            currentDate.plusWeeks(1)
        } else if (command.equals("-")) {
            currentDate.minusWeeks(1)
        }
        loadTimetable()
    }

    override fun switchWeek(dt: DateTime) {
        currentDate = dt
        loadTimetable()
    }

    override fun loadTimetable() {
        if (name != "") {
            val start: DateTime
            val end: DateTime

            start = currentDate.dayOfWeek().setCopy(DateTimeConstants.MONDAY)
            end = currentDate.dayOfWeek().setCopy(DateTimeConstants.SUNDAY)

            val body = RequestTimeTable(dtf.print(start), dtf.print(end), name, type)

            interactor.getTimetable(body,
                callback = {
                    viewMain.setTimetable(it!!, currentDate)
                }
            )
        } else {
            getIserInfo()
        }
    }

    override fun switchType(type: String) {
        this.type = type

        if (type == "group")
        //viewMain.showSelectGroupFragment()
            router.navigateToSelectGroup()
        else if (type == "tutor")
        //viewMain.showSelectTutorFragment()
            router.navigateToSelectTutor()
        else if (type == "exam") {
            btn_origin = true
            loadTimetable()
            closeFragment()
        } else if (type == "user_id") {
            btn_origin = true
            loadTimetable()
            closeFragment()
        }
    }

    override fun switchName(name: String) {
        this.name = name
        viewMain.showName(name)

        btn_origin = !this.name.equals(originalName)
    }

    override fun returnOriginal() {
        type = originalType
        switchName(originalName)

        loadTimetable()

        closeFragment()
    }

    override fun closeFragment() {
        //viewMain.closeFragment()

        router.navController.popBackStack()
    }

    override fun navigateToCabinet(cabinet: String) {
        router.navigateToCabinet(cabinet)
    }

    override fun navigateToSelectType() {
        router.navigateToSelectType(btn_origin)
    }
}