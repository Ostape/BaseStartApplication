package com.robosh.basestartapplication

import android.util.Log
import com.robosh.basestartapplication.net.repository.PhotoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val photoRepository: PhotoRepository) {

    fun aaaaa() {
        photoRepository.getPhotos().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            Log.d("TAGGERR", it.toString())
        }
        Log.d("TAGGERR", "asdasdas")
    }
}