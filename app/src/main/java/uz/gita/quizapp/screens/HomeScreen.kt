package uz.gita.quizapp.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import uz.gita.quizapp.R
import uz.gita.quizapp.databinding.HomeScreenBinding
import uz.gita.quizapp.model.AppDatabase

class HomeScreen : Fragment() {
    private var _binding: HomeScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.chapter1.setOnClickListener {
            val bundle = Bundle().apply {
                putString("key", "English")
            }
            findNavController().navigate(R.id.action_homeScreen_to_questionScreen, bundle)
        }
        binding.chapter2.setOnClickListener {
            val bundle = Bundle().apply {
                putString("key", "Geography")
            }
            findNavController().navigate(R.id.action_homeScreen_to_questionScreen, bundle)
        }
        binding.chapter3.setOnClickListener {
            val bundle = Bundle().apply {
                putString("key", "Physics")
            }
            findNavController().navigate(R.id.action_homeScreen_to_questionScreen, bundle)
        }
        binding.chapter4.setOnClickListener {
            val bundle = Bundle().apply {
                putString("key", "Computer")
            }
            findNavController().navigate(R.id.action_homeScreen_to_questionScreen, bundle)
        }

    }





    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}