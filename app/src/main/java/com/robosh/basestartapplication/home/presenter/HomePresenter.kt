package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.net.repository.PhotoRepository
import kotlinx.coroutines.launch

class HomePresenter(private val photoRepository: PhotoRepository) : ViewModel() {

    fun aaaaa() {
        Log.d("TAGGERR", "asdasdas")

        viewModelScope.launch {
            photoRepository.getPhotos().isSuccessful
            Log.d("TAGGERR", photoRepository.getPhotos().body().toString())
        }
    }
}