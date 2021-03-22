package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.home.presenter.HomePresenter
import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.mapper.PhotoMapper
import com.robosh.basestartapplication.net.repository.PhotoRepository
import com.robosh.basestartapplication.net.repository.PhotoRepositoryImpl
import org.koin.dsl.module

val netModule = module {
    factory { HomePresenter(get()) }

    single { RetrofitClientInstance.retrofitInstance }

    single<PhotoRepository> { PhotoRepositoryImpl(get()) }

    single<PhotoMapper> { PhotoMapper() }
}