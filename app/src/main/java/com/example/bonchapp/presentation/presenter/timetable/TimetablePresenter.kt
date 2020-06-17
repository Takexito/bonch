package com.example.bonchapp.presentation.presenter.timetable

import com.example.bonchapp.domain.interactors.timetable.ITimetableInteractor
import com.example.bonchapp.presentation.timetable.ui.ITimetableView
import com.example.bonchapp.router.MainRouter
import org.joda.time.DateTime
import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.presentation.ui.timetable.main.TimetableViewPagerFragment
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

    var listPagers = arrayListOf<TimetableViewPagerFragment>(
    )

    init {
        //initPagersList()
    }

    override fun getAttachView(): ITimetableView {
        return viewMain
    }

    override fun attachView(viewMain: ITimetableView) {
        this.viewMain = viewMain
    }

//    fun initPagersList() {
//        listPagers.add(
//            TimetableViewPagerFragment(currentDate.minusWeeks(1),this
//            )
//        )
//        listPagers.add(
//            TimetableViewPagerFragment(currentDate,this
//            )
//        )
//        listPagers.add(
//            TimetableViewPagerFragment(currentDate.plusWeeks(1),this
//            )
//        )
//
////        updateTimetable(listPagers[0], currentDate.minusWeeks(1))
////        updateTimetable(listPagers[1], currentDate)
////        updateTimetable(listPagers[2], currentDate.plusWeeks(1))
//    }

    override fun getPagersList(): ArrayList<TimetableViewPagerFragment> {
        return listPagers
    }

//    override fun switchWeek(command: String) {
//        if (command.equals("+")) {
//            currentDate = currentDate.plusWeeks(1)
//            var p = listPagers[0]
//            listPagers.removeAt(0)
//            listPagers.add(p)
//            //updateTimetable(p, currentDate.plusWeeks(1))
//            p.setDate(currentDate.plusWeeks(1))
//
//        } else {
//            currentDate = currentDate.minusWeeks(1)
//            var p = listPagers[2]
//            listPagers.removeAt(2)
//            listPagers.add(0, p)
//            //updateTimetable(p, currentDate.minusWeeks(1))
//            p.setDate(currentDate.minusWeeks(1))
//        }
//    }

    override fun switchWeek(dt: DateTime) {
        currentDate = dt
        //updateTimetable()
    }


    override fun updateTimetable(fragment: TimetableViewPagerFragment, date: DateTime, callback: (data: ArrayList<SubjectDTO>?) -> Unit) {
        if (name != "") {
            val start: DateTime
            val end: DateTime

            start = date.dayOfWeek().setCopy(DateTimeConstants.MONDAY)
            end = date.dayOfWeek().setCopy(DateTimeConstants.SUNDAY)

            val body = RequestTimeTable(dtf.print(start), dtf.print(end), name, type)

            interactor.getTimetable(body,
                callback = {
                    //fragment.updateTimetable(it!!, date)
                    callback(it)
                }
            )
        }
    }

//    override fun updateTimetable() {
//        if (name != "") {
//            val start: DateTime
//            val end: DateTime
//
//            start = currentDate.minusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.MONDAY)
//            end = currentDate.minusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.SUNDAY)
//
//            val body0 = RequestTimeTable(
//                dtf.print(
//                    currentDate.minusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.MONDAY)
//                ),
//                dtf.print(
//                    currentDate.minusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.SUNDAY)
//                ), name, type
//            )
//            val body1 = RequestTimeTable(
//                dtf.print(
//                    currentDate.dayOfWeek().setCopy(DateTimeConstants.MONDAY)
//                ),
//                dtf.print(
//                    currentDate.dayOfWeek().setCopy(DateTimeConstants.SUNDAY)
//                ), name, type
//            )
//            val body2 = RequestTimeTable(
//                dtf.print(
//                    currentDate.plusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.MONDAY)
//                ),
//                dtf.print(
//                    currentDate.plusWeeks(1).dayOfWeek().setCopy(DateTimeConstants.SUNDAY)
//                ), name, type
//            )
//
//            interactor.getTimetable(body0,
//                callback = {
//                    //listPagers[0].updateTimetable(it!!, currentDate.minusWeeks(1))
//                    listPagers[2].setDate(currentDate.minusWeeks(1))
//
//                }
//            )
//            interactor.getTimetable(body1,
//                callback = {
//                    //listPagers[1].updateTimetable(it!!, currentDate)
//                    listPagers[2].setDate(currentDate)
//
//                }
//            )
//            interactor.getTimetable(body2,
//                callback = {
//                    //listPagers[2].updateTimetable(it!!, currentDate.plusWeeks(1))
//                    listPagers[2].setDate(currentDate.plusWeeks(1))
//                }
//            )
//        }
//    }

    override fun switchType(type: String) {
        this.type = type

        viewMain.closeFragment()

//        if (type == "group")
//            viewMain.showSelectGroupFragment()
//        else if (type == "tutor")
//            viewMain.showSelectTutorFragment()
//        else if (type == "exam")
//            updateTimetable()
//        else if (type == "user_id")
//            updateTimetable()
    }

    override fun switchName(name: String) {
        this.name = name
        viewMain.closeFragment()
        viewMain.showName(name)
        //updateTimetable()
    }
}