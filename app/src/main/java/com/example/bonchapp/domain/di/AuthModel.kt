package com.example.bonchapp.domain.di

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.repository.AuthRepository
import com.example.bonchapp.domain.interactors.auth.AuthInteractor
import com.example.bonchapp.domain.interactors.auth.IAuthInteractor
import com.example.bonchapp.domain.repository.IAuthRepository
import com.example.bonchapp.presentation.presenter.auth.AuthPresenter
import com.example.bonchapp.presentation.presenter.auth.IAuthPresenter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
class AuthModel {
    @Provides
    fun providePresenter(authInteractor: IAuthInteractor, router: MainRouter): IAuthPresenter {
        return AuthPresenter(
            authInteractor,
            router
        )
    }

    @Provides
    fun provideInteractor(repository: IAuthRepository): IAuthInteractor {
        return AuthInteractor(
            repository
        )
    }

    @Provides
    fun provideRepository(networkService: NetworkService): IAuthRepository {
        return AuthRepository(networkService)
    }
}