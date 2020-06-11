package com.example.bonchapp.presentation.ui.profile

import com.example.bonchapp.domain.entities.AccountDTO

interface IProfileView {
    fun setData(data: AccountDTO)
}