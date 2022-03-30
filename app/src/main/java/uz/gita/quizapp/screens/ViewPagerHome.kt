package uz.gita.quizapp.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.quizapp.R
import uz.gita.quizapp.adapter.ViewPagerAdapter
import uz.gita.quizapp.databinding.ViewPagerHomeBinding
import java.util.prefs.AbstractPreferences

class ViewPagerHome : Fragment() {
    private var _binding: ViewPagerHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewPagerHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences = requireActivity().getSharedPreferences("key", Context.MODE_PRIVATE)
        val adapter = ViewPagerAdapter(this)
        binding.viewPagerId.adapter = adapter
        binding.dotId.setViewPager2(binding.viewPagerId)
        binding.nextBtn.setOnClickListener {
            val currentPosition = binding.viewPagerId.currentItem
            if(currentPosition+1==adapter.itemCount){
                sharedPreferences.edit().putInt("key",currentPosition+1).commit()
                findNavController().navigate(R.id.action_viewPagerHome_to_homeScreen)
            }
            else{
                binding.viewPagerId.currentItem++
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}