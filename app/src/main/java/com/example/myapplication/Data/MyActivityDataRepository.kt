package com.example.myapplication.Data

import com.example.myapplication.ListItem
import org.joda.time.DateTime

class MyActivityDataRepository {

    private val datePattern = "dd.MM.YYYY"

//    private val data = mapOf<Int, ListItem>(
//        1 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        2 to ListItem.Card(2 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), ""),
//        3 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        4 to ListItem.Card(2 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), ""),
//        5 to ListItem.Date(1, DateTime.now().toString(datePattern)),
//        6 to ListItem.Card(2 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), ""),
//    )

    private val data = listOf<ListItem>(
        ListItem.Date(0, DateTime.now().toString(datePattern)),
        ListItem.Card(1 , "100 км", "60 мин", "Бег", DateTime.now().toString(datePattern), ""),
        ListItem.Date(2, DateTime.now().toString(datePattern)),
        ListItem.Card(3 , "150 км", "90 мин", "Бег", DateTime.now().toString(datePattern), "")
    )


    fun getData() = data

    private fun getMaxId() = data.maxOf{it.id}
}