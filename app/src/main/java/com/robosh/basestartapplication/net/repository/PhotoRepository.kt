package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.net.model.PhotoResponse
import io.reactivex.Observable

interface PhotoRepository {

    fun getPhotos(): Observable<List<PhotoResponse>>
}