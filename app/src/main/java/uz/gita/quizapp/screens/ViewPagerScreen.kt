package uz.gita.quizapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.gita.quizapp.databinding.ViewPagerScreenBinding
import uz.gita.quizapp.model.Data.SetIntroData

class ViewPagerScreen : Fragment() {
    private var _binding : ViewPagerScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewPagerScreenBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = arguments!!.getInt("key")
        val listData = SetIntroData().getVPData()
        binding.imgId.setImageResource(listData[position].image)
        binding.text1Id.text = getString(listData[position].text1)
        binding.text2Id.text = getString(listData[position].text2)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}