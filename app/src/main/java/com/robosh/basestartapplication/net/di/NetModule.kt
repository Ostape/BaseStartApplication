package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.home.presenter.HomeViewModel
import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.mapper.MovieMapper
import com.robosh.basestartapplication.net.repository.MovieRepository
import com.robosh.basestartapplication.net.repository.MovieRepositoryImpl
import org.koin.dsl.module

val netModule = module {
    factory { HomeViewModel(get()) }

    single { RetrofitClientInstance.retrofitInstance }

    single<MovieRepository> { MovieRepositoryImpl(get()) }

    single<MovieMapper> { MovieMapper() }
}