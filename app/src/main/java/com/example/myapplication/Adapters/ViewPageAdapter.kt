package com.example.myapplication.Adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ActivityFragmentTabs.MyActivity
import com.example.myapplication.ActivityFragmentTabs.UsersActivity

public const val ARG_OBJECT = "object"

class ViewPageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) MyActivity() else UsersActivity()
    }
}