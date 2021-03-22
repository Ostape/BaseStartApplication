package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.api.PokemonApi
import com.robosh.basestartapplication.net.model.PokemonListResponse
import retrofit2.Response
import retrofit2.Retrofit

class PokemonRepositoryImpl(
    private val retrofit: Retrofit
) : PokemonRepository {

    override suspend fun getPokemonsReference(): Response<PokemonListResponse> {
        return retrofit.create(PokemonApi::class.java).getPokemonsReference()
    }
}