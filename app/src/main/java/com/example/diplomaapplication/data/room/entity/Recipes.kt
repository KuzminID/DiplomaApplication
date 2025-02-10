package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "recipes",
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["result_item_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "recipe_name")
    val name : String,
    @ColumnInfo(name = "result_item_id")
    val resultItemID : Int
)
