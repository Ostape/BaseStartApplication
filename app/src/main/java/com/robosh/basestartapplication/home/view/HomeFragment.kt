package com.robosh.basestartapplication.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.robosh.basestartapplication.home.presenter.HomeViewModel
import com.robosh.basestartapplication.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var bookNotesAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookNotesAdapter = PhotoAdapter(null)
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
        homeViewModel.aaaaa()
    }

    private fun initRecyclerView() {
        with(binding.listOfBooksRecyclerView) {
            setHasFixedSize(true)
            adapter = bookNotesAdapter
            layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
        }
    }
}
