package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Locations(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "location_name")
    val name: String,
    @ColumnInfo(name = "location_description")
    val description: String
)
