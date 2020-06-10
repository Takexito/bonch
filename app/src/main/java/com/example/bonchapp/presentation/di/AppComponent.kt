package com.example.bonchapp.presentation.di

import com.example.bonchapp.data.di.NetworkModule
import com.example.bonchapp.domain.di.BaseModule
import com.example.bonchapp.domain.di.ProfileModule
import com.example.bonchapp.presentation.ui.profile.ProfileFragment
import com.example.bonchapp.presentation.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.presentation.ui.profile.elective.ProfileElectivesFragment
import com.example.bonchapp.presentation.ui.profile.mark.ProfileMarkFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
        //EventModule::class,
        //AuthModel::class,
        BaseModule::class,
        ProfileModule::class
        //TimetableModule::class
    ]
)
interface AppComponent {

    //fun inject(action: MainActivity)
    //fun inject(view: AuthFragment)
    fun inject(view: ProfileDebtFragment)
    fun inject(view: ProfileMarkFragment)
    fun inject(view: ProfileElectivesFragment)
    fun inject(view: ProfileFragment)

}
