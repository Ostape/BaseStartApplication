package com.robosh.basestartapplication.net.mapper

import com.robosh.basestartapplication.model.Photo
import com.robosh.basestartapplication.net.model.PhotoResponse

class PhotoMapper {

    fun map(photoResponse: List<PhotoResponse>): List<Photo> {
        return photoResponse.map {
            Photo(it.id, it.urls.full ?: "")
        }
    }
}