package com.example.braintrainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.braintrainer.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.nav.observe(viewLifecycleOwner, Observer {
            if (it) {
                val action =
                    GameFragmentDirections.actionGameFragmentToGameWinFragment(score = viewModel.corr_total.value.toString())
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