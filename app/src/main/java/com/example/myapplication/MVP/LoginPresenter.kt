package com.example.myapplication.MVP

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.myapplication.DTO.RegisterDTO
import com.example.myapplication.Network.LoginService
import com.example.myapplication.R

class LoginPresenter {

    private var view: LoginView? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: LoginView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onLoginClicked(login: String, password: String, sharedPrefs: SharedPreferences){
        if(login.isBlank()){
            view?.showLoginError()
            return
        }

        if(password.isBlank()){
            view?.showPasswordError()
            return
        }

        loginService.login(login, password, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                sharedPrefs.edit()?.putString("Token", result.token)?.apply()
                navController?.navigate(R.id.action_loginFragment_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }

        })
    }

}