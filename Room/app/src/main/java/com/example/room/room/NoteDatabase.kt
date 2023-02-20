package com.example.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            //if the INSTANCE is not null, then return it
            //if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}