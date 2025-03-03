package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Recipe

@Dao
abstract class RecipesDao : BaseDao<Recipe>() {
}