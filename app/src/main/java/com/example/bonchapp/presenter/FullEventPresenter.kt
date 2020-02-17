package com.example.bonchapp.presenter

import android.view.View
import com.example.bonchapp.R
import com.example.bonchapp.ui.event.FullEventFragment
import com.google.android.material.snackbar.Snackbar

class FullEventPresenter(val context: FullEventFragment) {

    fun onRegButtonPress(view: View){
        //registration()
        Snackbar.make(view, R.string.reg_success, Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun registration(){
        TODO("request to server")
    }

    fun onCreate() {
        //setDataToView()
    }

    private fun setDataToView() {
        TODO("request data and set them to view")
    }
}