package com.example.bonchapp.presenter.event

import androidx.fragment.app.Fragment

interface Presenter {
    fun onItemClick(position: Int)
    fun onItemLike(it1: String)

    val fragment: Fragment
}