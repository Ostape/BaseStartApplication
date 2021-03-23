package com.robosh.basestartapplication.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.basestartapplication.databinding.FragmentHomeBinding
import com.robosh.basestartapplication.home.presenter.HomeViewModel
import com.robosh.basestartapplication.model.MovieEvent
import com.robosh.basestartapplication.model.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject

@ExperimentalCoroutinesApi
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bookNotesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookNotesAdapter = MovieAdapter(null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homeViewModel.state.onEach {
            render(it)
        }.launchIn(lifecycleScope)
        homeViewModel.intentChannel.offer(MovieEvent.MoviesFetch)
    }

    private fun initRecyclerView() {
        with(binding.listOfBooksRecyclerView) {
            setHasFixedSize(true)
            adapter = bookNotesAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
        }
    }

    private fun render(movieState: MovieState) {
        when (movieState) {
            is MovieState.DataListState -> bookNotesAdapter.setData(movieState.data)
        }
    }
}
