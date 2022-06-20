package com.example.myapplication.MVP

interface LoginView {

    fun showLoginError()

    fun showPasswordError()

    fun showToast(message: String)

}