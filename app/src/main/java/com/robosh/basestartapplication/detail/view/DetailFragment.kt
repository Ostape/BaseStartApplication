package com.robosh.basestartapplication.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.robosh.basestartapplication.databinding.FragmentDetailBinding
import com.robosh.basestartapplication.detail.presenter.DetailViewModel
import com.robosh.basestartapplication.model.MovieEvent
import com.robosh.basestartapplication.model.MovieState
import com.robosh.basestartapplication.net.api.MovieDbApi
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.state.onEach {
            render(it)
        }.launchIn(lifecycleScope)
        detailViewModel.intentChannel.offer(MovieEvent.MoviesFetch)
    }

    private fun render(movieState: MovieState) {
        when (movieState) {
            is MovieState.SingleDataState -> {
                binding.detailMovieDescription.text = movieState.movie.description
                Picasso.get().load(MovieDbApi.IMAGE_BASE_URL + movieState.movie.posterUrl)
                    .into(binding.detailMovieImage)
                binding.detailMovieTitle.text = movieState.movie.title
            }
        }
    }

}
