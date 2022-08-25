package com.example.cosc345

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Sentence::class], version = 1, exportSchema = false)
abstract class SentenceDatabase: RoomDatabase() {
    abstract fun sentenceDao(): SentenceDAO

    companion object{
        @Volatile
        private var INSTANCE: SentenceDatabase?  = null

        fun getDatabase(context: Context): SentenceDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SentenceDatabase::class.java,
                    "sentences"
                ).build()
                INSTANCE = instance
                return instance

            }

        }
    }
}