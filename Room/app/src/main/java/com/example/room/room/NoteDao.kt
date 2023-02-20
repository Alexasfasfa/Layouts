package com.example.room.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.room.Note

@Dao
interface NoteDao {

    @Insert
   suspend fun insert(note: Note)

    @Delete
   suspend fun delete(note: Note)

    @Update
   suspend fun update(note: Note)

    @Query("DELETE FROM note_table")
   suspend fun deleteAllNote()

    @Query("SELECT * FROM note_table ORDER BY priority ASC")
    fun getAllNotes(): LiveData<MutableList<Note>>
}