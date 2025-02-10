package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "events",
    foreignKeys = [
        ForeignKey(
            entity = EventTypes::class,
            parentColumns = ["id"],
            childColumns = ["event_type_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Events(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    @ColumnInfo(name = "location_description")
    val description : String,
    @ColumnInfo(name = "encounter_chance")
    val chance : Double,
    @ColumnInfo(name = "event_type_id")
    val eventTypeID : Int
)
