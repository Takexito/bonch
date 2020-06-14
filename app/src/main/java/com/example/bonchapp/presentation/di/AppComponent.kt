package com.example.bonchapp.presentation.di

import com.example.bonchapp.data.di.NetworkModule
import com.example.bonchapp.domain.di.AuthModel
import com.example.bonchapp.domain.di.BaseModule
import com.example.bonchapp.domain.di.EventModule
import com.example.bonchapp.domain.di.MessageModule
import com.example.bonchapp.presentation.ui.MainActivity
import com.example.bonchapp.presentation.ui.authorization.AuthFragment
import com.example.bonchapp.presentation.ui.event.BaseEventFragment
import com.example.bonchapp.presentation.ui.event.favorite.FavoriteEventFragment
import com.example.bonchapp.presentation.ui.event.main.MainEventFragment
import com.example.bonchapp.presentation.ui.event.my.MyEventFragment
import com.example.bonchapp.presentation.ui.message.MessageFragment
import com.example.bonchapp.presentation.ui.message.MessageInFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, EventModule::class, AuthModel::class, BaseModule::class, MessageModule::class])
interface AppComponent {

    fun inject(view: MainEventFragment)
    fun inject(view: MyEventFragment)
    fun inject(view: FavoriteEventFragment)

    fun inject(action: MainActivity)

    fun inject(view: AuthFragment)

    fun inject(view: MessageFragment)
    fun inject(view: MessageInFragment)
    fun inject(baseEventFragment: BaseEventFragment)
}