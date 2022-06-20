package com.example.myapplication.MVP

interface ProfileView {

    fun showToast(message: String)

    fun getData(
        name: String,
        login: String,
        token: String
    )

}