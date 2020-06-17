package com.example.bonchapp.domain.di

import com.example.bonchapp.data.api.NetworkService
import com.example.bonchapp.data.repository.ProfileRepository
import com.example.bonchapp.domain.interactors.profile.IProfileInteractor
import com.example.bonchapp.domain.interactors.profile.ProfileInteractor
import com.example.bonchapp.domain.repository.IProfileRepository
import com.example.bonchapp.presentation.presenter.profile.IProfilePresenter
import com.example.bonchapp.presentation.presenter.profile.ProfilePresenter
import com.example.bonchapp.presentation.presenter.profile.debt.IProfileDebtPresenter
import com.example.bonchapp.presentation.presenter.profile.electives.IProfileElectivesPresenter
import com.example.bonchapp.presentation.presenter.profile.debt.ProfileDebtPresenter
import com.example.bonchapp.presentation.presenter.profile.electives.ProfileElectivesPresenter
import com.example.bonchapp.presentation.presenter.profile.mark.IProfileMarkPresenter
import com.example.bonchapp.presentation.presenter.profile.mark.ProfileMarkPresenter
import com.example.bonchapp.router.MainRouter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProfileModule {

    @Provides
    @Singleton
    fun provideDebtPresenter(profileInteractor: IProfileInteractor): IProfileDebtPresenter {
        return ProfileDebtPresenter(
            profileInteractor
        )
    }

    @Provides
    @Singleton
    fun provideElectivesPresenter(profileInteractor: IProfileInteractor): IProfileElectivesPresenter {
        return ProfileElectivesPresenter(profileInteractor
        )
    }

    @Provides
    @Singleton
    fun provideMarkPresenter(profileInteractor: IProfileInteractor): IProfileMarkPresenter {
        return ProfileMarkPresenter(profileInteractor
        )
    }

    @Provides
    @Singleton
    fun providePresenter(profileInteractor: IProfileInteractor): IProfilePresenter {
        return ProfilePresenter(profileInteractor
        )
    }

    @Provides
    @Singleton
    fun provideInteractor(repository: IProfileRepository): IProfileInteractor{
        return ProfileInteractor(repository)
    }

    @Provides
    @Singleton
    fun provideRepository(networkService: NetworkService): IProfileRepository{
        return ProfileRepository(networkService)
    }
}
