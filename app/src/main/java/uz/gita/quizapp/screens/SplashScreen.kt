package uz.gita.quizapp.screens

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.quizapp.R
import uz.gita.quizapp.databinding.SplashScreenBinding


class SplashScreen : Fragment() {
    private var _binding: SplashScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences = requireActivity().getSharedPreferences("key",Context.MODE_PRIVATE)
        val countDownTimer = object : CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (sharedPreferences.getInt("key",0)==0){
                    findNavController().navigate(R.id.action_splashScreen_to_viewPagerHome)
                }
                else{
                    findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
                }

            }

        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}