package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "recipes",
    foreignKeys = [
        ForeignKey(entity = Item::class, parentColumns = ["id"], childColumns = ["result_item_id"]),
        ForeignKey(
            entity = Skill::class,
            parentColumns = ["id"],
            childColumns = ["required_skill_id"]
        )
    ]
)
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "result_item_id")
    val resultItemId: Int,
    @ColumnInfo(name = "required_skill_id")
    val requiredSkillId: Int,
    @ColumnInfo(name = "required_skill_level")
    val requiredSkillLevel: Int
)

@Entity(
    tableName = "recipe_ingredients",
    foreignKeys = [
        ForeignKey(entity = Item::class, parentColumns = ["id"], childColumns = ["item_id"]),
        ForeignKey(entity = Recipe::class, parentColumns = ["id"], childColumns = ["recipe_id"])
    ]
)
data class RecipeIngredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_id")
    val itemId: Int,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @ColumnInfo(name = "recipe_id")
    val recipeId: Int
)