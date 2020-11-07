package com.example.braintrainer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.braintrainer.databinding.FragmentGameStartBinding


class GameStartFragment : Fragment() {
    private lateinit var binding:FragmentGameStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGameStartBinding.inflate(inflater)
        binding.go.setOnClickListener {
            findNavController().navigate(R.id.action_gameStartFragment_to_gameFragment)
        }
        return binding.root
    }
}



