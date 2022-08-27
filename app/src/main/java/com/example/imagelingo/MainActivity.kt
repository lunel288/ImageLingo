@file:Suppress("DEPRECATION")

package com.example.imagelingo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val wordList = listOf<String>("Pen", "Laptop", "Clock")
    private val translationList = listOf<String>("Pene", "Rorohiko", "Karaka")
    private lateinit var btnTranslate: Button
    private lateinit var btnCapture: Button
    private lateinit var txtInput: TextView
    private lateinit var txtOutput: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCapture = findViewById(R.id.btnCapture)
        btnTranslate = findViewById(R.id.btnTranslate)
        txtInput = findViewById(R.id.txtInput)
        txtOutput = findViewById(R.id.txtOutput)
        imageView = findViewById(R.id.imageView)

        btnTranslate.setOnClickListener(this)
        btnCapture.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(takenImage)
        }
        super.onActivityResult(requestCode, resultCode, data)
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

            R.id.btnCapture -> {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if(takePictureIntent.resolveActivity(this.packageManager) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                } else{
                    Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun main(){


    }

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 42
    }
}