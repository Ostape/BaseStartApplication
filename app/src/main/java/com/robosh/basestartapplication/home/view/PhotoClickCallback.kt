package com.robosh.basestartapplication.home.view

import com.robosh.basestartapplication.net.model.MovieListResponse

interface PhotoClickCallback {

    fun onBookClicked(photo: MovieListResponse)
}