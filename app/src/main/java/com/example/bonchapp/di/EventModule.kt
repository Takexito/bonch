package com.example.bonchapp.di

import com.example.bonchapp.data.network.NetworkService
import com.example.bonchapp.data.repository.EventRepository
import com.example.bonchapp.data.repository.IEventRepository
import com.example.bonchapp.domain.interactor.event.EventInteractor
import com.example.bonchapp.domain.interactor.event.IEventInteractor
import com.example.bonchapp.presentation.presenter.event.EventPresenter
import com.example.bonchapp.presentation.presenter.event.IEventPresenter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
class EventModule {

    @Provides
    fun providePresenter(eventInteractor: IEventInteractor, router: MainRouter): IEventPresenter {
        return EventPresenter(
            eventInteractor,
            router
        )
    }

    @Provides
    fun provideInteractor(repository: IEventRepository): IEventInteractor{
        return EventInteractor(repository)
    }

    @Provides
    fun provideRouter(): MainRouter{
        return MainRouter()
    }

    @Provides
    fun provideRepository(networkService: NetworkService): IEventRepository{
        return EventRepository(
            networkService
        )
    }
}