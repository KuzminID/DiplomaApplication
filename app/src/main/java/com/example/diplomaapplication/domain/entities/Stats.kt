package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stats")
data class Stats(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "health")
    val health: Int,
    @ColumnInfo(name = "strength")
    val strength: Int,
    @ColumnInfo(name = "agility")
    val agility: Int,
    @ColumnInfo(name = "intelligence")
    val intelligence: Int,
    @ColumnInfo(name = "vitality")
    val vitality: Int
)
