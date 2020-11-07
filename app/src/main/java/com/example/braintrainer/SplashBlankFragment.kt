package com.example.braintrainer

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


class SplashBlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_splash_blank, container, false)

        Handler().postDelayed(Runnable {
            findNavController().navigate(R.id.action_splashBlankFragment_to_gameStartFragment)
        },3000)

        return view
    }

}