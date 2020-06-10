package com.example.bonchapp.presentation.ui.profile.debt

import com.example.bonchapp.domain.entities.DebtDTO

interface IProfileDebtView {
    fun setData(list: ArrayList<ArrayList<DebtDTO>>)
    fun hideRV(b:Boolean)
}