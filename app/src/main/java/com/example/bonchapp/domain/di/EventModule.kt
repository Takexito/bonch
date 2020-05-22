package com.example.bonchapp.domain.di

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.repository.EventRepository
import com.example.bonchapp.domain.interactors.event.EventInteractor
import com.example.bonchapp.domain.interactors.event.IEventInteractor
import com.example.bonchapp.domain.repository.IEventRepository
import com.example.bonchapp.presentation.presenter.event.MainEventPresenter
import com.example.bonchapp.presentation.presenter.event.IMainEventPresenter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
class EventModule {
    @Provides
    fun providePresenter(eventInteractor: IEventInteractor, router: MainRouter): IMainEventPresenter {
        return MainEventPresenter(
            eventInteractor,
            router
        )
    }

    @Provides
    fun provideInteractor(repository: IEventRepository): IEventInteractor {
        return EventInteractor(
            repository
        )
    }

    @Provides
    fun provideRepository(networkService: NetworkService): IEventRepository{
        return EventRepository(networkService)
    }

}