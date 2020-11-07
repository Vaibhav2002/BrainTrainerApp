package com.example.braintrainer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.braintrainer.databinding.FragmentGameWinBinding

class GameWinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentGameWinBinding.inflate(inflater)
        binding.scoretext.text=GameWinFragmentArgs().score
        binding.playagainbtn.setOnClickListener {
            findNavController().navigate(GameWinFragmentDirections.actionGameWinFragmentToGameStartFragment())
        }
        return binding.root
    }

}