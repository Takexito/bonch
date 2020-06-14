package com.example.bonchapp.domain.repository

import com.example.bonchapp.domain.entities.AccountDTO
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.ElectiveDTO
import com.example.bonchapp.domain.entities.MarkDTO
import retrofit2.Response

interface IProfileRepository {
    fun loadUserInfo (callback: (resp: Response<AccountDTO>) -> Unit, callbackError: (error: String) -> Unit)
    fun loadDebt (callback: (resp: Response<ArrayList<DebtDTO>>) -> Unit, callbackError: (error: String) -> Unit)
    fun loadElectives (callback: (resp: Response<ArrayList<ElectiveDTO>>) -> Unit, callbackError: (error: String) -> Unit)
    fun loadMark (callback: (resp: Response<ArrayList<MarkDTO>>) -> Unit, callbackError: (error: String) -> Unit)

}