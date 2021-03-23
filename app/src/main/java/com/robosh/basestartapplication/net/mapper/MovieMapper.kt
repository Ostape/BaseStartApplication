package com.robosh.basestartapplication.net.mapper

import com.robosh.basestartapplication.model.Movie
import com.robosh.basestartapplication.net.model.MovieResponse

class MovieMapper {

    fun map(movieListResponse: List<MovieResponse>): List<Movie> {
        val resultMovies = mutableListOf<Movie>()
        movieListResponse.forEach {
            resultMovies.add(
                Movie(
                    it.id,
                    it.title,
                    it.description,
                    it.posterPath
                )
            )
        }
        return resultMovies
    }
}