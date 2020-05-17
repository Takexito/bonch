package com.example.bonchapp.presentation.presenter.event

import com.example.bonchapp.presentation.ui.storage.StorageFragment

class StoragePresenter(val context: StorageFragment) {

    var data = mutableListOf("Мой Файл 1", "Мой Файл 2", "Мой Файл 3", "Мой Файл 4", "Мой Файл 5", "Мой Файл 6", "Мой Файл 7")

    fun onCreate() {

    }

    fun onSpinnerSelectedItemUpdated(itemPosition: Int) {
        when (itemPosition) {
            0 -> data = mutableListOf("Мой Файл 1", "Мой Файл 2", "Мой Файл 3", "Мой Файл 4", "Мой Файл 5", "Мой Файл 6", "Мой Файл 7")
            1 -> data = mutableListOf("Файл группы 1", "Файл группы 2", "Файл группы 3", "Файл группы 4", "Файл группы 5", "Файл группы 6", "Файл группы 7")
            2 -> data = mutableListOf("Файл библиотека 1", "Файл библиотека 2", "Файл библиотека 3", "Файл библиотека 4", "Файл библиотека 5", "Файл библиотека 6", "Файл библиотека 7")
            3 -> data = mutableListOf("bonchfile 1", "bonchfile 2", "bonchfile 3", "bonchfile 4", "bonchfile 5", "bonchfile 6", "bonchfile 7")
        }
        context.updateAdapter(data)
    }
}