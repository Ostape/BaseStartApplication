package com.robosh.basestartapplication.net.usecase

import android.util.Log
import com.robosh.basestartapplication.model.MovieState
import com.robosh.basestartapplication.net.mapper.MovieMapper
import com.robosh.basestartapplication.net.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : GetMoviesUseCase {

    override suspend fun execute(): MovieState {
        val movieListResponse = movieRepository.getMovieListReference()
        return if (movieListResponse.isSuccessful) {

            Log.d("TAGGERR by ID", movieRepository.getMovieById(100).body().toString())
            MovieState.DataListState(
                movieMapper.map(movieListResponse.body()?.results ?: emptyList())
            )
        } else {
            MovieState.ErrorState("Some error occurred: ${movieListResponse.errorBody()}")
        }
    }
}