package com.example.bonchapp.model.repository

import androidx.lifecycle.LiveData
import com.example.bonchapp.model.pojo.AccountDTO
import com.example.bonchapp.model.pojo.DebtDTO
import com.example.bonchapp.model.pojo.ElectiveDTO
import com.example.bonchapp.model.pojo.MarkDTO

interface IProfileRepository {
    fun getUserInfo() : LiveData<AccountDTO>
    fun getDebt() : LiveData<ArrayList<DebtDTO>>
    fun getElectives() : LiveData<ArrayList<ElectiveDTO>>
    fun getMark() : LiveData<ArrayList<MarkDTO>>
}