package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "npc",
    foreignKeys = [
        ForeignKey(entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.CASCADE)])
data class NPC(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "location_id")
    val locationId: Int
)