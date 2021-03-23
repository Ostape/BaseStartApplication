package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.home.usecase.GetMoviesUseCase
import com.robosh.basestartapplication.home.usecase.GetMoviesUseCaseImpl
import com.robosh.basestartapplication.net.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val getMoviesUseCase: GetMoviesUseCase = GetMoviesUseCaseImpl()

    fun aaaaa() {
        Log.d("TAGGERR", "asdasdas")

        viewModelScope.launch {
            Log.d("TAGGERR", getMoviesUseCase.execute().toString())
        }
    }
}