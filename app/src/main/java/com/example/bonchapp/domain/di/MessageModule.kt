package com.example.bonchapp.domain.di

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.repository.EventRepository
import com.example.bonchapp.data.repository.MessageRepository
import com.example.bonchapp.domain.interactors.IMessageInteractor
import com.example.bonchapp.domain.interactors.MessageInteractor
import com.example.bonchapp.domain.repository.IEventRepository
import com.example.bonchapp.domain.repository.IMessageRepository
import com.example.bonchapp.presentation.presenter.message.IMessagePresenter
import com.example.bonchapp.presentation.presenter.message.MessagePresenter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
class MessageModule{
    @Provides
    fun providePresenter(messageInteractor: IMessageInteractor, router: MainRouter): IMessagePresenter {
        return MessagePresenter(
            messageInteractor,
            router
        )
    }

    @Provides
    fun provideInteractor(repository: IMessageRepository): IMessageInteractor {
        return MessageInteractor(
            repository
        )
    }

    @Provides
    fun provideRepository(networkService: NetworkService): IMessageRepository {
        return MessageRepository(networkService)
    }
}