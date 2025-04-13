package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_stats",
    foreignKeys = [
        ForeignKey(
            entity = Stats::class,
            parentColumns = ["id"],
            childColumns = ["stats_id"]
        ),
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        )
    ]
) //TODO add foreign key
data class CharacterStats(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "stats_id")
    val statsId: Long,
    @ColumnInfo(name = "character_id")
    val characterId: Long
)
