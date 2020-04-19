package com.example.bonchapp.presentation

import android.app.Application
import com.example.bonchapp.di.AppComponent
import com.example.bonchapp.di.DaggerAppComponent

class App: Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerAppComponent.builder().build()
    }
}