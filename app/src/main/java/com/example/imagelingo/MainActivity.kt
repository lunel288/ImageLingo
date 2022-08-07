package com.example.imagelingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val wordList = listOf<String>("Pen", "Laptop", "Clock")
    private val translationList = listOf<String>("Pene", "Rorohiko", "Karaka")
    private lateinit var btnTranslate: Button
    private lateinit var txtInput: TextView
    private lateinit var txtOutput: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTranslate = findViewById(R.id.btnTranslate)
        txtInput = findViewById(R.id.txtInput)
        txtOutput = findViewById(R.id.txtOutput)

        btnTranslate.setOnClickListener(this)


        }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnTranslate -> {
                val input: String = txtInput.text.toString()
                for ( i  in 0..(translationList.size-1)) {
                    if (input == wordList[i]) {
                        txtOutput.setText(translationList[i])
                        break
                    }
                    else{ //word not in list
                        txtOutput.setText(R.string.invalid_word)
                    }
                }
            }
        }
    }



    fun main(){


    }
}