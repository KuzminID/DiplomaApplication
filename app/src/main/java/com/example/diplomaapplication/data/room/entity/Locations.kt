package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Locations(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "location_name")
    val name : String,
    @ColumnInfo(name = "location_description")
    val description : String,
    @ColumnInfo(name = "drop_rate_multiplier")
    val dropRateMultiplier : Double,
    @ColumnInfo(name = "enemy_stat_multiplier")
    val enemyStatMultiplier : Double
)
