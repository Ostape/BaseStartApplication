package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.model.Photo

interface PhotoClickListenerFactory {

    fun createOnClickListener(photo: Photo): View.OnClickListener
}