package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Recipe

@Dao
abstract class RecipesDao : BaseDao<Recipe>() {
}