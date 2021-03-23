package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.net.usecase.GetMoviesUseCase
import com.robosh.basestartapplication.net.usecase.GetMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetMoviesUseCase(getMoviesUseCaseImpl: GetMoviesUseCaseImpl): GetMoviesUseCase =
        getMoviesUseCaseImpl
}
