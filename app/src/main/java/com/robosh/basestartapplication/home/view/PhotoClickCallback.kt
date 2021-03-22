package com.robosh.basestartapplication.home.view

import com.robosh.basestartapplication.net.model.PokemonListResponse

interface PhotoClickCallback {

    fun onBookClicked(photo: PokemonListResponse)
}