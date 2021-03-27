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
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

    private fun render(movieState: MovieState) {
        when (movieState) {
            is MovieState.DataListState -> movieAdapter.setData(movieState.data)
        }
    }

    override fun onMovieRemindClicked(movie: Movie) {
        val instance = Calendar.getInstance()
        instance.set(Calendar.MINUTE, instance.get(Calendar.MINUTE))
        instance.set(Calendar.SECOND, instance.get(Calendar.SECOND) + 10)
        startAlarm(instance)
    }

    private fun startAlarm(calendar: Calendar) {
        val manager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent: PendingIntent

        val myIntent = Intent(requireContext(), AlarmNotificationReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, myIntent, 0)

        Log.d("TAGGGG", calendar.timeInMillis.toString())
        Log.d("TAGGGG", System.currentTimeMillis().toString())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        } else {
            manager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        }
    }
}
