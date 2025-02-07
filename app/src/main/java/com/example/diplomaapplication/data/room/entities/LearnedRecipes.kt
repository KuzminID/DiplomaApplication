package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "learned_recipes",
    foreignKeys = [
        ForeignKey(entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Recipe::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE)])
data class LearnedRecipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "character_id")
    val characterId: Int,

    @ColumnInfo(name = "recipe_id")
    val recipeId: Int
)