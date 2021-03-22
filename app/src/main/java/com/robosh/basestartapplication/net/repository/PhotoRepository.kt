package com.robosh.basestartapplication.net.repository

import com.robosh.basestartapplication.model.Photo
import com.robosh.basestartapplication.net.model.PhotoResponse
import retrofit2.Response

interface PhotoRepository {

    suspend fun getPhotos(): Response<List<PhotoResponse>>
}