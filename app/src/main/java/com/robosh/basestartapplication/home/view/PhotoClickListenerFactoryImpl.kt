package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.net.model.PokemonListResponse

class PhotoClickListenerFactoryImpl(
    private val callback: PhotoClickCallback
) : PhotoClickListenerFactory {

    override fun createOnClickListener(photo: PokemonListResponse): View.OnClickListener {
        return View.OnClickListener {
            callback.onBookClicked(photo)
        }
    }
}