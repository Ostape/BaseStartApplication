package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.net.model.MovieListResponse

class PhotoClickListenerFactoryImpl(
    private val callback: PhotoClickCallback
) : PhotoClickListenerFactory {

    override fun createOnClickListener(photo: MovieListResponse): View.OnClickListener {
        return View.OnClickListener {
            callback.onBookClicked(photo)
        }
    }
}