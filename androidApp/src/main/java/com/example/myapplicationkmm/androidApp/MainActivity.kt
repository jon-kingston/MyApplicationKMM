package com.example.myapplicationkmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplicationkmm.shared.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.text_view)

        tv.text = greet()
    }

    fun buttonClick(view: View) {
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = count.toString()
        count++
    }
}
