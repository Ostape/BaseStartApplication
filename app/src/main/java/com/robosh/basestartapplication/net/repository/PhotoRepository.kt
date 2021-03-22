package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.model.PokemonListResponse
import retrofit2.Response

interface PhotoRepository {

    suspend fun getPhotos(): Response<List<PokemonListResponse>>
}