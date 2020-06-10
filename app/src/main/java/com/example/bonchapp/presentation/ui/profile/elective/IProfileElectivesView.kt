package com.example.bonchapp.presentation.ui.profile.elective

import com.example.bonchapp.domain.entities.ElectiveDTO

interface IProfileElectivesView {
    fun setData(list: ArrayList<ElectiveDTO>)
    fun hideRV(b:Boolean)
}