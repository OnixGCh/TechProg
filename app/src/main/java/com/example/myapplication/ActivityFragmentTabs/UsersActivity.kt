package com.example.myapplication.ActivityFragmentTabs

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapters.RecyclerAdapter
import com.example.myapplication.Data.MyActivityDataRepository
import com.example.myapplication.Data.UsersActivityDataRepository
import com.example.myapplication.R

class UsersActivity: Fragment(R.layout.tabs_fragment_users_activity)  {

    private val usersActivityData = UsersActivityDataRepository()
    private val adapter = RecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@UsersActivity.adapter
        }

        adapter.setData(usersActivityData.getData())
    }

}