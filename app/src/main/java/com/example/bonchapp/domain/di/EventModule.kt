package com.example.bonchapp.domain.di

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.repository.EventRepository
import com.example.bonchapp.domain.interactors.event.EventInteractor
import com.example.bonchapp.domain.interactors.event.IEventInteractor
import com.example.bonchapp.domain.repository.IEventRepository
import com.example.bonchapp.presentation.presenter.event.*
import com.example.bonchapp.presentation.ui.event.favorite.FavoriteEventAdapter
import com.example.bonchapp.presentation.ui.event.main.EventAdapter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventModule {
    @Provides
    fun provideMainPresenter(eventInteractor: IEventInteractor, router: MainRouter): IMainEventPresenter {
        return MainEventPresenter(
            eventInteractor,
            router
        )
    }
    @Singleton
    @Provides
    fun provideFavoritePresenter(eventInteractor: IEventInteractor, router: MainRouter): IFavoriteEventPresenter {
        return FavoriteEventPresenter(
            eventInteractor,
            router
        )
    }
    @Provides
    fun provideMyPresenter(eventInteractor: IEventInteractor, router: MainRouter): IMyEventPresenter {
        return MyEventPresenter(
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

    @Provides
    fun provideFavoriteAdapter(presenter: IFavoriteEventPresenter): FavoriteEventAdapter{
        return FavoriteEventAdapter(presenter)
    }

}