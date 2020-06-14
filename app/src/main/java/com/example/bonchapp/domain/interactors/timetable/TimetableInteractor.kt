package com.example.bonchapp.domain.interactors.timetable

import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.domain.repository.ITimetableRepository
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.router.User
import javax.inject.Inject

class TimetableInteractor @Inject constructor(val repository: ITimetableRepository) :
    ITimetableInteractor {
    override fun getTimetable(
        req: RequestTimeTable,
        callback: (data: ArrayList<SubjectDTO>?) -> Unit
    ) {
        repository.loadTimetable(req,
            callback = {
                if (it.isSuccessful) callback(it.body())

            },
            callbackError = {}
        )
    }

    override fun getGroupList(
        callback: (data: ArrayList<ArrayList<String>>?) -> Unit
    ) {
        repository.loadGroups(
            callback = {
                if (it.isSuccessful) callback(it.body())

            },
            callbackError = {}
        )
    }

    override fun getTutorList(
        callback: (data: ArrayList<String>?) -> Unit
    ) {
        repository.loadTutors(
            callback = {
                if (it.isSuccessful) callback(it.body())

            },
            callbackError = {}
        )
    }
}
