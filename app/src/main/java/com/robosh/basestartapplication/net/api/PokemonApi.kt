package com.robosh.basestartapplication.net.api

import com.robosh.basestartapplication.net.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon?limit=30&offset=30")
    suspend fun getPokemonsReference(): Response<PokemonListResponse>
}