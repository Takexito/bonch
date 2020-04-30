package com.example.bonchapp.ui.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StorageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is storage Fragment"
    }
    val text: LiveData<String> = _text
}