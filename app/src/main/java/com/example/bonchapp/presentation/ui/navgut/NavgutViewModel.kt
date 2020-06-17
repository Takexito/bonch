package com.example.bonchapp.presentation.ui.navgut

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavgutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is navgut Fragment"
    }
    val text: LiveData<String> = _text
}