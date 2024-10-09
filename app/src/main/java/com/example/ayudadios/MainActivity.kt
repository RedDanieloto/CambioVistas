package com.example.ayudadios

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)
        val startButton = findViewById<View>(R.id.startButton)

        startButton.setOnClickListener {
            startTimer()
        }
    }

    private fun startTimer() {
        timerTextView.visibility = View.VISIBLE
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualizar el TextView con los segundos restantes
                timerTextView.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // Navegar a la segunda vista cuando el temporizador termina
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}