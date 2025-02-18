package com.simsek.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.simsek.tictactoe.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.twoPlayerButton.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToGameFragment()
            Navigation.findNavController(it).navigate(action)
            onDestroy()
        }

        binding.quitButton.setOnClickListener{
            requireActivity().finishAndRemoveTask()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}