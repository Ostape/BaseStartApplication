package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.HomePresenter
import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.repository.PhotoRepository
import com.robosh.basestartapplication.net.repository.PhotoRepositoryImpl
import org.koin.dsl.module

val netModule = module {
    factory { HomePresenter(get()) }

    single { RetrofitClientInstance.retrofitInstance }

    single<PhotoRepository> { PhotoRepositoryImpl(get()) }
}