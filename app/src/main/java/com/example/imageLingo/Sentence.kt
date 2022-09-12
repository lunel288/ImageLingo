package com.example.imageLingo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sentences")
data class Sentence (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lang: String,
    val obj: String,
    val no: Int,
    val text: String
)