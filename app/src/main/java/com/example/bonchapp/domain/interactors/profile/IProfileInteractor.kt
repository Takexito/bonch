package com.example.bonchapp.domain.interactors.profile

import com.example.bonchapp.domain.entities.AccountDTO
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.ElectiveDTO
import com.example.bonchapp.domain.entities.MarkDTO

interface IProfileInteractor {
    fun getUserInfo(
        callback: (data: AccountDTO?) -> Unit
    )
    fun getDebt(
        callback: (data: ArrayList<DebtDTO>?) -> Unit
    )
    fun getElectives(
        callback: (data: ArrayList<ElectiveDTO>?) -> Unit
    )
    fun getMark(
        callback: (data: ArrayList<MarkDTO>?) -> Unit
    )

}