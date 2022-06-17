package com.example.myapplication.MVP

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.myapplication.DTO.RegisterDTO
import com.example.myapplication.Network.LoginService
import com.example.myapplication.R

class RegistrationPresenter {

    private var view: RegistrationView? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: RegistrationView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onRegistrationClicked(
        login: String,
        password: String,
        name: String,
        gender: Int
    ){
        if(login.isBlank()){
            view?.showLoginError()
            return
        }

        if(password.isBlank()){
            view?.showPasswordError()
            return
        }

        if(name.isBlank()){
            view?.showNameError()
            return
        }

        if (!(gender == 0 || gender == 1 || gender == 2)){
            view?.showToast("Выберите пол")
            return
        }

        loginService.register(login, password, name, gender, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                view?.saveToken(result.token)
                navController?.navigate(R.id.action_registrationFragment_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }

        })
    }


}