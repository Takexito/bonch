package com.example.bonchapp.domain.repository

import com.example.bonchapp.domain.entities.RequestTimeTable
import com.example.bonchapp.domain.entities.Token
import com.example.bonchapp.pojo.SubjectDTO
import com.example.bonchapp.router.User
import retrofit2.Response

interface ITimetableRepository {
    fun loadTimetable (req: RequestTimeTable, callback: (resp: Response<ArrayList<SubjectDTO>>) -> Unit, callbackError: (error: String) -> Unit)
    fun loadGroups (callback: (resp: Response<ArrayList<ArrayList<String>>>) -> Unit, callbackError: (error: String) -> Unit)
    fun loadTutors (callback: (resp: Response<ArrayList<String>>) -> Unit, callbackError: (error: String) -> Unit)
}
