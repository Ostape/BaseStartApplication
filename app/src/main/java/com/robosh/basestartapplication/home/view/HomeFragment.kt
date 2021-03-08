package com.robosh.basestartapplication.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.robosh.basestartapplication.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToTest.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_testFragment)
        }
    }
}
