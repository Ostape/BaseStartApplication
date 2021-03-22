package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.model.Photo

class PhotoClickListenerFactoryImpl(
    private val callback: PhotoClickCallback
) : PhotoClickListenerFactory {

    override fun createOnClickListener(photo: Photo): View.OnClickListener {
        return View.OnClickListener {
            callback.onBookClicked(photo)
        }
    }
}