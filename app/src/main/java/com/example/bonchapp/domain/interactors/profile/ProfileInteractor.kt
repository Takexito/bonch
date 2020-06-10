package com.example.bonchapp.domain.interactors.profile

import com.example.bonchapp.domain.entities.AccountDTO
import com.example.bonchapp.domain.entities.DebtDTO
import com.example.bonchapp.domain.entities.ElectiveDTO
import com.example.bonchapp.domain.entities.MarkDTO
import com.example.bonchapp.domain.repository.IProfileRepository
import javax.inject.Inject

class ProfileInteractor @Inject constructor(val repository: IProfileRepository) :
    IProfileInteractor {
    override fun getUserInfo(callback: (data: AccountDTO?) -> Unit) {
        repository.loadUserInfo(
            callback = {
                if (it.isSuccessful) callback(it.body())
            },
            callbackError = {}
        )
    }

    override fun getDebt(callback: (data: ArrayList<DebtDTO>?) -> Unit) {
        repository.loadDebt(
            callback = {
                if (it.isSuccessful) callback(it.body())
            },
            callbackError = {}
        )
    }

    override fun getElectives(callback: (data: ArrayList<ElectiveDTO>?) -> Unit) {
        repository.loadElectives(
            callback = {
                if (it.isSuccessful) callback(it.body())
            },
            callbackError = {}
        )
    }

    override fun getMark(callback: (data: ArrayList<MarkDTO>?) -> Unit) {
        repository.loadMark(
            callback = {
                if (it.isSuccessful) callback(it.body())
            },
            callbackError = {}
        )
    }

}