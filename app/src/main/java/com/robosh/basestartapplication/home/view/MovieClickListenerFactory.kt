package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.model.Movie
import com.robosh.basestartapplication.net.model.MovieListResponse

interface MovieClickListenerFactory {

    fun createOnClickListener(movie: Movie): View.OnClickListener
}