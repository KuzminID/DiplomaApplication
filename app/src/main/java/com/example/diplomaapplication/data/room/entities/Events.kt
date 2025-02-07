package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "events",
    foreignKeys = [
        ForeignKey(entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.CASCADE)])
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "event_type")
    val eventType: String,

    @ColumnInfo(name = "location_id")
    val locationId: Int,

    @ColumnInfo(name = "probability")
    val probability: Float
)