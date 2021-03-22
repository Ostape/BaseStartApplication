package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.api.UnsplashApi
import com.robosh.basestartapplication.net.model.PokemonListResponse
import retrofit2.Response
import retrofit2.Retrofit

class PhotoRepositoryImpl(
    private val retrofit: Retrofit
) : PhotoRepository {

    override suspend fun getPhotos(): Response<List<PokemonListResponse>> {
        return retrofit.create(UnsplashApi::class.java).getPhotos()
    }
}