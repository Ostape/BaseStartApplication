package com.robosh.basestartapplication.net.api

import com.robosh.basestartapplication.net.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface UnsplashApi {

    @GET("pokemon?limit=100&offset=200")
    suspend fun getPhotos(): Response<PokemonListResponse>
}