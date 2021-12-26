package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.net.repository.PokemonRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    fun aaaaa() {
        viewModelScope.launch {
            pokemonRepository.getPokemonsReference().isSuccessful
        }
    }
}