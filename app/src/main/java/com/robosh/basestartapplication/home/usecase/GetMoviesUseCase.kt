package com.robosh.basestartapplication.home.usecase

import com.robosh.basestartapplication.model.MovieState

interface GetMoviesUseCase {

    suspend fun execute(): MovieState
}