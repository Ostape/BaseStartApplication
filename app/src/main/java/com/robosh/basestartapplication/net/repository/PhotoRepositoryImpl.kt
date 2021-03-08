package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.api.UnsplashApi
import com.robosh.basestartapplication.net.model.PhotoResponse
import io.reactivex.Observable
import retrofit2.Retrofit

class PhotoRepositoryImpl(private val retrofit: Retrofit) : PhotoRepository {

    override fun getPhotos(): Observable<List<PhotoResponse>> {
        return retrofit.create(UnsplashApi::class.java).getPhotos()
    }
}