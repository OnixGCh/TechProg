package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.registrationButton).setOnClickListener {
            findNavController().navigate(R.id.action_welcomeActivity_to_registrationActivity)
        }

        view.findViewById<TextView>(R.id.loginButton).setOnClickListener {
            findNavController().navigate(R.id.action_welcomeActivity_to_loginActivity)
        }
    }
}