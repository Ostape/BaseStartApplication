package com.robosh.basestartapplication.home.view

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.basestartapplication.application.INTENT_MOVIE_KEY
import com.robosh.basestartapplication.databinding.FragmentHomeBinding
import com.robosh.basestartapplication.home.presenter.HomeViewModel
import com.robosh.basestartapplication.model.Movie
import com.robosh.basestartapplication.model.MovieEvent
import com.robosh.basestartapplication.model.MovieState
import com.robosh.basestartapplication.receiver.AlarmNotificationReceiver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment(), MovieClickCallback {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieAdapter = MovieAdapter(MovieClickListenerFactoryImpl(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homeViewModel.state.onEach {
            render(it)
        }.launchIn(lifecycleScope)
        homeViewModel.intentChannel.offer(MovieEvent.MoviesFetch)
    }

    private fun initRecyclerView() {
        with(binding.listOfMoviesRecyclerView) {
            setHasFixedSize(true)
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
        }
    }

    override fun onMovieRemindClicked(movie: Movie) {
        homeViewModel.intentChannel.offer(MovieEvent.MovieClicked(movie))
    }

    private fun render(movieState: MovieState) {
        when (movieState) {
            is MovieState.DataListState -> showMoviesData(movieState)
            MovieState.Idle -> Unit
            MovieState.LoadingState -> showLoader()
            is MovieState.ErrorState -> showError()
            is MovieState.SingleDataState -> Unit
            is MovieState.MovieClickedState -> movieClicked(movieState.movie)
        }
    }

    private fun showMoviesData(movieState: MovieState.DataListState) {
        hideLoader()
        binding.listOfMoviesRecyclerView.visibility = VISIBLE
        movieAdapter.setData(movieState.data)
    }

    private fun showLoader() {
        with(binding) {
            progressBar.visibility = VISIBLE
            errorMessageMovies.visibility = GONE
            listOfMoviesRecyclerView.visibility = GONE
        }
    }

    private fun hideLoader() {
        binding.progressBar.visibility = GONE
    }

    private fun showError() {
        hideLoader()
        binding.errorMessageMovies.visibility = VISIBLE
    }

    private fun movieClicked(movie: Movie) {
        val instance = Calendar.getInstance()
        instance.set(Calendar.MINUTE, instance.get(Calendar.MINUTE))
        instance.set(Calendar.SECOND, instance.get(Calendar.SECOND) + 10)
        startAlarm(instance, movie)
    }

    private fun startAlarm(
        calendar: Calendar,
        movie: Movie
    ) {
        val manager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmNotificationIntent =
            Intent(requireContext(), AlarmNotificationReceiver::class.java).apply {
                putExtra(INTENT_MOVIE_KEY, movie.id)
            }
        val pendingIntent =
            PendingIntent.getBroadcast(
                requireContext(),
                0,
                alarmNotificationIntent,
                PendingIntent.FLAG_ONE_SHOT
            )

        Log.d("TAGGGG", calendar.timeInMillis.toString())
        Log.d("TAGGGG", System.currentTimeMillis().toString())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } else {
            manager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        }
    }
}
