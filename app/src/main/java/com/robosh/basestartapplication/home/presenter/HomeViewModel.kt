package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.net.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun aaaaa() {
        Log.d("TAGGERR", "asdasdas")

        viewModelScope.launch {
            movieRepository.getMovieListReference().isSuccessful
            Log.d("TAGGERR", movieRepository.getMovieListReference().message())
            Log.d("TAGGERR", movieRepository.getMovieListReference().body().toString())
        }
    }
}