package com.example.braintrainer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.braintrainer.databinding.FragmentGameBinding
import com.example.braintrainer.databinding.FragmentGameStartBinding
import kotlin.properties.Delegates

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = GameViewModel()
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.nav.observe(viewLifecycleOwner, Observer {
            if (it) {
                val action=GameFragmentDirections.actionGameFragmentToGameWinFragment(score=binding.score.text.toString())
                findNavController().navigate(action)
            }
        })

        binding.button0.setOnClickListener {
            viewModel.ansSelect(it.tag.toString())
        }
        binding.button1.setOnClickListener {
            viewModel.ansSelect(it.tag.toString())
        }
        binding.button2.setOnClickListener {
            viewModel.ansSelect(it.tag.toString())
        }
        binding.button3.setOnClickListener {
            viewModel.ansSelect(it.tag.toString())
        }


        return binding.root
    }


}