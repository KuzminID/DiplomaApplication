package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "character",
    foreignKeys = [
        ForeignKey(
            entity = Locations::class,
            parentColumns = ["id"],
            childColumns = ["current_location_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BaseClasses::class,
            parentColumns = ["id"],
            childColumns = ["base_class_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "level")
    val lvl : Int,
    @ColumnInfo(name = "experience")
    val exp : Int,
    @ColumnInfo(name = "current_location_id")
    val currentLocation : Int,
    @ColumnInfo(name = "base_class_id")
    val baseClassID : Int
)
