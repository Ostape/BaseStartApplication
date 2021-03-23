package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.model.MovieListResponse
import retrofit2.Response

interface MovieRepository {

    suspend fun getMovieListReference(): Response<MovieListResponse>
}