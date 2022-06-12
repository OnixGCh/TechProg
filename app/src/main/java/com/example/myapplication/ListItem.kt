package com.example.myapplication

sealed class ListItem(var id:Int){
    class Date(id: Int, val date: String): ListItem(id)
    class Card(id: Int,
               val distance: String,
               val time: String,
               val moveBy: String,
               val date: String,
               val user: String
               ): ListItem(id)

}
