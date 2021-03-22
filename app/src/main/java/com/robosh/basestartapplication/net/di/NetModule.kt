package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.home.presenter.HomeViewModel
import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.mapper.PhotoMapper
import com.robosh.basestartapplication.net.repository.PokemonRepository
import com.robosh.basestartapplication.net.repository.PokemonRepositoryImpl
import org.koin.dsl.module

val netModule = module {
    factory { HomeViewModel(get()) }

    single { RetrofitClientInstance.retrofitInstance }

    single<PokemonRepository> { PokemonRepositoryImpl(get()) }

    single<PhotoMapper> { PhotoMapper() }
}