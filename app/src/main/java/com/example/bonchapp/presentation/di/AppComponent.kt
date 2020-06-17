package com.example.bonchapp.presentation.di

import com.example.bonchapp.data.di.NetworkModule
import com.example.bonchapp.domain.di.BaseModule
import com.example.bonchapp.domain.di.TimetableModule
import com.example.bonchapp.presentation.timetable.ui.TimetableFragment
import com.example.bonchapp.presentation.ui.timetable.main.TimetableViewPagerFragment
import com.example.bonchapp.presentation.ui.timetable.selectGroup.SelectGroupFragment
import com.example.bonchapp.presentation.ui.timetable.selectGroup.SelectGroupPostHolder
import com.example.bonchapp.presentation.ui.timetable.selectTutor.SelectTutorFragment
import com.example.bonchapp.presentation.ui.timetable.selectTutor.SelectTutorPostHolder
import com.example.bonchapp.presentation.ui.timetable.selectType.SelectTypeTimetableFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
        //EventModule::class,
        //AuthModel::class,
        BaseModule::class,
        TimetableModule::class
    ]
)
interface AppComponent {
    fun inject(view: TimetableFragment)
    fun inject(view: SelectTypeTimetableFragment)
    fun inject(view: SelectGroupFragment)
    fun inject(view: SelectGroupPostHolder)
    fun inject(view: SelectTutorFragment)
    fun inject(view: SelectTutorPostHolder)
    fun inject(action: TimetableViewPagerFragment)
    //fun inject(view: AuthFragment)
}
