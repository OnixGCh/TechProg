package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MVP.LoginPresenter
import com.example.myapplication.MVP.LoginView
import com.example.myapplication.MVP.ProfilePresenter
import com.example.myapplication.MVP.ProfileView

class ProfileFragment: Fragment(R.layout.activity_fragment_profile), ProfileView {

    private val presenter = ProfilePresenter()
    private var navController: NavController? = null

    private val sharedPrefs by lazy {
        requireContext().getSharedPreferences("Tokens", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = parentFragment?.parentFragment?.findNavController()

        presenter.attachView(this)

        presenter.onViewCreated(sharedPrefs.getString("Token", "").toString())

        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            presenter.onLogoutClicked(sharedPrefs.getString("Token", "").toString())
            presenter.deleteToken(sharedPrefs, navController!!)
        }
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getData(name: String, login: String, token: String) {
        view?.findViewById<TextView>(R.id.name)?.text = name
        view?.findViewById<TextView>(R.id.login)?.text = login
        view?.findViewById<TextView>(R.id.token)?.text = sharedPrefs.getString("Token", "")
    }
}