package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients",
    foreignKeys = [
        ForeignKey(entity = Recipe::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE)])
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "recipe_id")
    val recipeId: Int,

    @ColumnInfo(name = "item_id")
    val itemId: Int,

    @ColumnInfo(name = "quantity")
    val quantity: Int
)