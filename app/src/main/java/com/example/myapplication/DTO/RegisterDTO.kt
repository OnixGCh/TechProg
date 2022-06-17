package com.example.myapplication.DTO

import com.google.gson.annotations.SerializedName

data class RegisterDTO (

    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: UserDTO

)