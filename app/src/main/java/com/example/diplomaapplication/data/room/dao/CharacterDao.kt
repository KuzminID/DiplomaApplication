package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.diplomaapplication.data.room.entity.Character

@Dao
interface CharacterDao {
    @Transaction
    @Query("SELECT * FROM character")
    fun getCharacters() : List<Character>

    @Transaction
    @Insert(onConflict = OnConflictStrategy. REPLACE)
    fun createCharacter(character : Character)
}