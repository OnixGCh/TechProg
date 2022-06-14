package com.example.myapplication.Data

import com.example.myapplication.ListItem
import org.joda.time.DateTime

class UsersActivityDataRepository {

    private val datePattern = "dd.MM.YYYY"

//    private val data = mapOf<Int, ListItem>(
//        7 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        8 to ListItem.Card(2 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//        9 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        10 to ListItem.Card(2 , "150 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//        11 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        12 to ListItem.Card(2 , "200 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
//    )

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(datePattern)),
        ListItem.Card(1 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
        ListItem.Date(2, DateTime.now().toString(datePattern)),
        ListItem.Card(3 , "200 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik"),
        ListItem.Date(4, DateTime.now().toString(datePattern)),
        ListItem.Card(5 , "150 км", "60 мин", "Бег", DateTime.now().toString(datePattern), "@bibik")
    )

    fun getData() = data

    //private fun getMaxId() = data.maxOf{it.id}

}