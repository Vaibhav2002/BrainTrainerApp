package com.example.braintrainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.braintrainer.databinding.FragmentGameWinBinding

class GameWinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGameWinBinding.inflate(inflater)
        val Score = GameWinFragmentArgs.fromBundle(requireArguments()).score
        val text: String = "Your scored ${Score.substring(0, Score.indexOf('/'))} " +
                "out of ${Score.substring(Score.indexOf('/') + 1)} questions"
        binding.scoretext.text = text
        binding.playagainbtn.setOnClickListener {
            findNavController().navigate(GameWinFragmentDirections.actionGameWinFragmentToGameStartFragment())
        }
        return binding.root
    }

}