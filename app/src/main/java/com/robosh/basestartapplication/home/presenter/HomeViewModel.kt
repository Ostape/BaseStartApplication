package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.net.repository.PokemonRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    fun aaaaa() {
        Log.d("TAGGERR", "asdasdas")

        viewModelScope.launch {
            pokemonRepository.getPokemonsReference().isSuccessful
            Log.d("TAGGERR", pokemonRepository.getPokemonsReference().body().toString())
        }
    }
}