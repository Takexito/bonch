package com.example.bonchapp.presentation.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.ui.event.main.MainEventFragment
import com.example.bonchapp.router.MainRouter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: MainRouter

    init {
        App.appComponent.inject(this)
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportFragmentManager.beginTransaction().add(MainEventFragment(),"" ).commit()

        navController = findNavController(R.id.nav_host_fragment_container)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_event,
            R.id.navigation_navgut,
            R.id.navigation_timetable,
            R.id.navigation_storage,
            R.id.navigation_profile
        ))
        navView.setupWithNavController(navController)

        router.navController = navController
    }

}
