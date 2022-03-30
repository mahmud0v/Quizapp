package uz.gita.quizapp.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle().apply {
            putInt("key", position)
        }
        val fragment = ViewPagerScreen()
        fragment.arguments = bundle
        return fragment
    }
}