package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity(R.layout.activity_helloworld) {

    private lateinit var helloBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helloBtn = findViewById<Button>(R.id.hello)

        helloBtn.setOnClickListener{
            helloBtn.setBackgroundColor((0..50000).random())
        }
    }
}