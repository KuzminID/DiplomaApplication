package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enemies")
data class Enemies(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "enemy_name")
    val name: String,
    @ColumnInfo(name = "enemy_description")
    val description: String,
    @ColumnInfo(name = "encounter_chance")
    val chance: Double
)

data class FullEnemyData(
    val id : Int
)
