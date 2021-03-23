package com.robosh.basestartapplication.net.api

import com.robosh.basestartapplication.net.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieDbApi {

    companion object {
        private const val API_KEY = "bf0af36b6b0149089510541e46af70f9"
        private const val API_KEY_QUERY = "?api_key=$API_KEY"
        const val QUERY_POPULAR_MOVIES = "movie/popular$API_KEY_QUERY"
        const val QUERY_MOVIE = "movie/{movie_id}$API_KEY_QUERY"

        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    @GET(QUERY_POPULAR_MOVIES)
    suspend fun getPopularMovieListReference(): Response<MovieListResponse>
}