package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.net.model.MovieListResponse

interface PhotoClickListenerFactory {

    fun createOnClickListener(photo: MovieListResponse): View.OnClickListener
}