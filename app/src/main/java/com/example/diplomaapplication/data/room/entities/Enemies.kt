package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enemies")
data class Enemy(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "level")
    val level: Int,

    @ColumnInfo(name = "health")
    val health: Int,

    @ColumnInfo(name = "attack")
    val attack: Int
)