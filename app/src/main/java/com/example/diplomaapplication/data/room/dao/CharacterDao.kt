package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Character

@Dao
abstract class CharacterDao : BaseDao<Character>() {

}