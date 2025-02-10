package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "location_events",
    foreignKeys = [
        ForeignKey(
            entity = Locations::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Events::class,
            parentColumns = ["id"],
            childColumns = ["event_id"]
        )
    ])
data class LocationEvents(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "location_id")
    val locationID : Int,
    @ColumnInfo(name = "event_id")
    val eventID : Int
)
