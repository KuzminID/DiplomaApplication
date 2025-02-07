package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "character_stats",
    foreignKeys = [
        ForeignKey(entity = Characters::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE)])
data class CharacterStat(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "character_id")
    val characterId: Int,

    @ColumnInfo(name = "stat_type")
    val statType: String,

    @ColumnInfo(name = "value")
    val value: Int
)
