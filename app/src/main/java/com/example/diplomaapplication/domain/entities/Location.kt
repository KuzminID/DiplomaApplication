package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "location_name")
    val name: String,
    @ColumnInfo(name = "location_description")
    val description: String,
    @ColumnInfo(name = "stat_multiplier")
    val statMultiplier: Double,
    @ColumnInfo(name = "drop_multiplier")
    val dropMultiplier: Double
)