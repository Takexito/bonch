package com.example.bonchapp.di

import com.example.bonchapp.presentation.ui.MainActivity
import com.example.bonchapp.presentation.ui.event.main.MainEventFragment
import dagger.Component

@Component(modules = [NetworkModule::class, EventModule::class])
interface AppComponent {

    fun inject(view: MainEventFragment)
    fun inject(action: MainActivity)
}