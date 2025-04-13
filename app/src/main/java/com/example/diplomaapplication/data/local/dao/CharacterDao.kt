package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.diplomaapplication.data.local.entities.Character

@Dao
interface CharacterDao {
    @Insert
    fun createCharacter(character: Character)

    @Query("SELECT * FROM character WHERE (user_id = :userId)")
    fun getAllUserCharacters(userId: Long): List<Character>?

    @Query("SELECT * FROM character WHERE (id = :characterId)")
    fun getCharacterById(characterId: Long): Character
}