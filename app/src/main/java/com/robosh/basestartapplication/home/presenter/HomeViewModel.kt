package com.robosh.basestartapplication.home.presenter

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robosh.basestartapplication.home.usecase.GetMoviesUseCase
import com.robosh.basestartapplication.home.usecase.GetMoviesUseCaseImpl
import com.robosh.basestartapplication.model.MovieEvent
import com.robosh.basestartapplication.model.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeViewModel @Inject constructor() : ViewModel() {

    private val getMoviesUseCase: GetMoviesUseCase = GetMoviesUseCaseImpl()

    val intentChannel = Channel<MovieEvent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MovieState>(MovieState.LoadingState)
    val state: StateFlow<MovieState>
        get() = _state

    init {
        viewModelScope.launch {
            obtainEvent()
        }
    }


    @VisibleForTesting
    suspend fun obtainEvent() {
        intentChannel.consumeEach { movieEvent ->
            when (movieEvent) {
                is MovieEvent.MoviesFetch -> {
                    Log.d("TAGGERR", getMoviesUseCase.execute().toString())
                    _state.value = getMoviesUseCase.execute()
                }
//                is BookNoteEvent.BookNoteClicked -> {
//                    _state.value = BookNoteState.BookNoteClickedState(bookNoteEvent.bookNote)
//                }
//                is BookNoteEvent.BookNoteSaved -> Unit
            }
        }
    }
}