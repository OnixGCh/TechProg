package com.example.myapplication.MVP

import android.content.SharedPreferences
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.myapplication.DTO.RegisterDTO
import com.example.myapplication.DTO.UserDTO
import com.example.myapplication.Network.LoginService
import com.example.myapplication.R

class ProfilePresenter {

    private var view: ProfileView? = null
    private val loginService = LoginService()

    fun attachView(view: ProfileView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onLogoutClicked(token: String){
        loginService.logout("Bearer $token", object : LoginService.LogoutCallback{
            override fun onSuccess() { }

            override fun onError() { }
        })
    }

    fun onViewCreated(token: String){
        loginService.profile("Bearer $token", object : LoginService.ProfileCallback{
            override fun onSuccess(result: UserDTO) {
                view?.getData(result.name, result.login, token)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }
        })
    }

    fun deleteToken(sharedPrefs: SharedPreferences, navController: NavController){
        sharedPrefs.edit().remove("Token").apply()
        navController.navigate(R.id.action_activityFragment_to_welcomeFragment)
    }

}