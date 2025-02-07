package com.example.diplomaapplication.data.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "character_events",
    foreignKeys = [ForeignKey(entity = Characters::class,
        parentColumns = ["id"],
        childColumns = ["character_id"],
        onDelete = ForeignKey.CASCADE)])
data class CharacterEvents(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val characterId : Int,
    val timestamp : Long,
    val eventDescription : String
)
