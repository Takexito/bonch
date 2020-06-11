package com.example.bonchapp.presentation

import android.app.Application
import android.preference.PreferenceManager
import com.example.bonchapp.MainActivity
import com.example.bonchapp.presentation.di.AppComponent
import com.example.bonchapp.presentation.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import java.util.*

class App: Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        AndroidThreeTen.init(this)


//        var change = ""
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        val language = sharedPreferences.getString("language", "bak")
//        if (language == "Russian") {
//            change="ru"
//        } else if (language=="English" ) {
//            change = "en"
//        }else {
//            change =""
//        }
//
//        MainActivity.dLocale = Locale(change) //set any locale you want here
    }
   fun updateConfig(){
        var change = ""
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val language = sharedPreferences.getString("language", "bak")
        if (language == "Russian") {
            change="ru"
        } else if (language=="English" ) {
            change = "en"
        }else {
            change =""
        }

        //MainActivity.dLocale = Locale(change) //set any locale you want here
    }
}
