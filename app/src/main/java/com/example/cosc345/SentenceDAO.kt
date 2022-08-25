package com.example.cosc345

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SentenceDAO {
    @Query("SELECT * FROM sentences WHERE obj = :obj")
    fun getSentencesByObject(obj: String): Array<Sentence>
}
