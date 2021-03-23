package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.api.MovieDbApi
import com.robosh.basestartapplication.net.model.MovieListResponse
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDbApi: MovieDbApi
) : MovieRepository {

    override suspend fun getMovieListReference(): Response<MovieListResponse> {
        return movieDbApi.getPopularMovieListReference()
    }
}