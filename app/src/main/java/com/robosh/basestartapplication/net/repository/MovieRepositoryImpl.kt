package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.api.MovieDbApi
import com.robosh.basestartapplication.net.model.MovieListResponse
import retrofit2.Response
import retrofit2.Retrofit

class MovieRepositoryImpl(
    private val retrofit: Retrofit
) : MovieRepository {

    override suspend fun getMovieListReference(): Response<MovieListResponse> {
        return retrofit.create(MovieDbApi::class.java).getPopularMovieListReference()
    }
}