package com.example.cosc345

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val translator = Translator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var capture: FloatingActionButton
        val startbutton = findViewById<Button>(R.id.startButton)
        startbutton.setOnClickListener {
            setContentView(R.layout.activity_capture)
            capture = findViewById(R.id.floatingActionButton)

        }
    }
}