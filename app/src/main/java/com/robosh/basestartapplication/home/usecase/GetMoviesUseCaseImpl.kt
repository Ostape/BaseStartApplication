package com.robosh.basestartapplication.home.usecase

import com.robosh.basestartapplication.model.MovieState
import com.robosh.basestartapplication.net.RetrofitClientInstance
import com.robosh.basestartapplication.net.api.MovieDbApi
import com.robosh.basestartapplication.net.mapper.MovieMapper
import com.robosh.basestartapplication.net.repository.MovieRepository
import com.robosh.basestartapplication.net.repository.MovieRepositoryImpl

class GetMoviesUseCaseImpl : GetMoviesUseCase {

    private val movieRepository: MovieRepository =
        MovieRepositoryImpl(RetrofitClientInstance.retrofitInstance.create(MovieDbApi::class.java))
    private val movieMapper = MovieMapper()

    override suspend fun execute(): MovieState {
        val movieListResponse = movieRepository.getMovieListReference()
        return if (movieListResponse.isSuccessful) {
            MovieState.DataListState(
                movieMapper.map(movieListResponse.body()?.results ?: emptyList())
            )
        } else {
            MovieState.ErrorState("Some error occurred: ${movieListResponse.errorBody()}")
        }
    }
}