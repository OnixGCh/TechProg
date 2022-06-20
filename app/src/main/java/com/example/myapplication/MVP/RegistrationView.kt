package com.example.myapplication.MVP

interface RegistrationView {

    fun showLoginError()

    fun showPasswordError()

    fun showNameError()

    fun showToast(message: String)

}