package com.example.bonchapp.presentation.di

import com.example.bonchapp.data.di.NetworkModule
import com.example.bonchapp.domain.di.AuthModel
import com.example.bonchapp.domain.di.BaseModule
import com.example.bonchapp.domain.di.EventModule
import com.example.bonchapp.presentation.ui.MainActivity
import com.example.bonchapp.presentation.ui.authorization.AuthFragment
import com.example.bonchapp.presentation.ui.event.main.MainEventFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, EventModule::class, AuthModel::class, BaseModule::class])
interface AppComponent {
    fun inject(view: MainEventFragment)
    fun inject(action: MainActivity)
    fun inject(view: AuthFragment)
}