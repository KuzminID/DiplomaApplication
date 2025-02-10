package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_ingredients",
    foreignKeys = [
        ForeignKey(
            entity = Recipes::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["ingredient_item_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class RecipeIngredients(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "recipe_id")
    val recipeID : Int,
    @ColumnInfo(name = "ingredient_name")
    val name : String,
    @ColumnInfo(name = "ingredient_item_id")
    val ingredientID : Int
)
