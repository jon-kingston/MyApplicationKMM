package com.example.myapplicationkmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.myapplicationkmm.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import com.example.myapplicationkmm.androidApp.databinding.ActivityMainBinding
import com.example.myapplicationkmm.shared.TicTacToyGameLogic

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var step = 0
    var table = Array(4) { Array(4) { 0 } }
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onImageClick(view: View) {
        var row = 0
        var col = 0
        step++

        if (view.tag.toString().toInt() == 0) {

            (view as ImageView).setImageResource(if (step % 2 == 0) R.drawable.o else R.drawable.cros)
            view.tag = if (step % 2 == 0) 4 else 1

            row = view.transitionName[0].toString().toInt()
            col = view.transitionName[1].toString().toInt()

            table[row][col] = view.tag.toString().toInt()
            when(TicTacToyGameLogic().checkWinner(table)){
                "xWin" -> xWin()
                "oWin" -> oWin()
                "noOne" -> noOne()
            }

        }
    }

    fun xWin(){
        Toast.makeText(this, "X Winn!!!", Toast.LENGTH_SHORT).show()
        android.os.Handler().postDelayed({ clear() }, 2000)
    }

    fun oWin(){
        Toast.makeText(this, "O Winn!!!", Toast.LENGTH_SHORT).show()
        android.os.Handler().postDelayed({ clear() }, 2000)
    }

    fun noOne(){
        Toast.makeText(this, "No One", Toast.LENGTH_SHORT).show()
        android.os.Handler().postDelayed({ clear() }, 2000)
    }

    fun clear(){
        binding.apply {
            image11.setImageResource(R.drawable.button)
            image11.tag = 0
            image12.setImageResource(R.drawable.button)
            image12.tag = 0
            image13.setImageResource(R.drawable.button)
            image13.tag = 0

            image21.setImageResource(R.drawable.button)
            image21.tag = 0
            image22.setImageResource(R.drawable.button)
            image22.tag = 0
            image23.setImageResource(R.drawable.button)
            image23.tag = 0

            image31.setImageResource(R.drawable.button)
            image31.tag = 0
            image32.setImageResource(R.drawable.button)
            image32.tag = 0
            image33.setImageResource(R.drawable.button)
            image33.tag = 0
        }
        for(i in 0..3){
            for(j in 0..3){
                table[i][j]=0
            }
        }
    }
}
