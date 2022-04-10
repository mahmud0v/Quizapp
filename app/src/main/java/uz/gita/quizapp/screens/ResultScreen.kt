package uz.gita.quizapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.gita.quizapp.R
import uz.gita.quizapp.databinding.ResultScreenBinding

class ResultScreen : Fragment() {
    private var _binding: ResultScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResultScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val correctAnswerNumber = requireArguments().getInt("key")
        binding.rightAnswer.text = correctAnswerNumber.toString()
        binding.homeId.setOnClickListener {
            findNavController().navigate(R.id.action_resultScreen_to_homeScreen)
        }

        binding.exitId.setOnClickListener {
            requireActivity().finish()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding == null
    }
}