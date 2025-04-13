package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_table")
data class Events(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    /**
     *@param type = 1 is Encounter
     *@param type = 2 is Treasure Found
     *@param type = 3 is Rest
     *@param type = 4 is Trap
     */
    @ColumnInfo(name = "event_type")
    val type: Int,
    @ColumnInfo(name = "event_name")
    val name: String,
    @ColumnInfo(name = "event_chance")
    val chance: Double
)
