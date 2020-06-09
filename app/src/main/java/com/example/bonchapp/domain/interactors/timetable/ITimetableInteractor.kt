package com.example.bonchapp.domain.interactors.timetable

import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.router.User
import retrofit2.Response

interface ITimetableInteractor {
    fun getTimetable(req: RequestTimeTable, callback: (data: ArrayList<SubjectDTO>?) -> Unit)
    fun getGroupList(
        callback: (data: ArrayList<ArrayList<String>>?) -> Unit
    )
    fun getTutorList(
        callback: (data: ArrayList<String>?) -> Unit
    )
}
