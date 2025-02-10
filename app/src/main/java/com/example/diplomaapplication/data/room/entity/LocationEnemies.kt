package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "location_enemies",
    foreignKeys = [
        ForeignKey(
            entity = Locations::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Enemies::class,
            parentColumns = ["id"],
            childColumns = ["enemy_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class LocationEnemies(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "location_id")
    val locationID : Int,
    @ColumnInfo(name = "enemy_id")
    val enemyID : Int,
    @ColumnInfo(name = "encounter_chance")
    val encounterChance : Double
    )
