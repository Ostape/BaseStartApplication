package com.robosh.basestartapplication.home.view

import android.view.View
import com.robosh.basestartapplication.net.model.PokemonListResponse

interface PhotoClickListenerFactory {

    fun createOnClickListener(photo: PokemonListResponse): View.OnClickListener
}