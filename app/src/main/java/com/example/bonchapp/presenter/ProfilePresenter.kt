package com.example.bonchapp.presenter

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bonchapp.model.pojo.DebtDTO
import com.example.bonchapp.model.repository.ProfileRepository
import com.example.bonchapp.ui.profile.ProfileFragment

class ProfilePresenter (val fragment:Fragment, pf:ProfileFragment){
    val mModel = ProfileRepository()
    val mView = pf

    init{
        getUser()
        getDebt()
        getElective()
        getMark()
    }

    fun getUser(){
        mModel.getUserInfo().observe(fragment.viewLifecycleOwner, Observer {
            val f = it
            mView.showUser(it)
        })
    }
    fun getDebt(){
        mModel.getDebt().observe(fragment.viewLifecycleOwner, Observer {
            val f = it
            mView.showDebt(it)
        })
    }
    fun getElective(){
        mModel.getElectives().observe(fragment.viewLifecycleOwner, Observer {
            val f = it
            mView.showElectives(it)
        })
    }
    fun getMark(){
        mModel.getMark().observe(fragment.viewLifecycleOwner, Observer {
            val f = it
            mView.showMark(it)
        })
    }
}