package com.example.bonchapp.presentation.ui.profile.mark

import com.example.bonchapp.domain.entities.MarkDTO

interface IProfileMarkView {
    fun setData(list: ArrayList<ArrayList<MarkDTO>>)
    fun hideRV(b:Boolean)
}