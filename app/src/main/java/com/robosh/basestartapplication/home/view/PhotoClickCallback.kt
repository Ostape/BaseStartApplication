package com.robosh.basestartapplication.home.view

import com.robosh.basestartapplication.model.Photo

interface PhotoClickCallback {

    fun onBookClicked(photo: Photo)
}