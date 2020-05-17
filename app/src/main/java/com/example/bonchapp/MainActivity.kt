package com.example.bonchapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bonchapp.coordinator.Keys
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.coordinator.User
import com.example.bonchapp.model.pojo.Token

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_event, R.id.navigation_navgut, R.id.navigation_timetable, R.id.navigation_storage,R.id.navigation_profile))
        navView.setupWithNavController(navController)


        val sharedPreferences = getSharedPreferences(Keys.APP_PREFERENCE, Context.MODE_PRIVATE)
        if(sharedPreferences.contains(Keys.TOKEN)) {
            User.addToken(Token(sharedPreferences.getString(Keys.TOKEN, "")!!))
            MainCoordinator.navigateToTimetable(this)
        }
    }
}
