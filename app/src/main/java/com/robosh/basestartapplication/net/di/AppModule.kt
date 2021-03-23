package com.robosh.basestartapplication.net.di

import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.api.MovieDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance() = RetrofitClientInstance.retrofitInstance

    @Singleton
    @Provides
    fun provideMovieDbApi(retrofit: Retrofit): MovieDbApi = retrofit.create(MovieDbApi::class.java)
}
