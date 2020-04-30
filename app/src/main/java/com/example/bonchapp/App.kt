package com.example.bonchapp

import android.app.Application
//import com.example.bonchapp.di.AppComponent
//import com.example.bonchapp.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen

class App: Application() {

    companion object{
       // lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        //appComponent = DaggerAppComponent.builder().build()
        AndroidThreeTen.init(this)

    }
}