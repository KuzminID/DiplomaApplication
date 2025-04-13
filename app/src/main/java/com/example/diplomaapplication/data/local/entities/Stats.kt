package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "stats",
    foreignKeys = [
        ForeignKey(entity = Stat::class, parentColumns = ["id"], childColumns = ["stat_id"])
    ]
) //TODO add foreign key
data class Stats(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "stat_id")
    val statId: Long,
    @ColumnInfo(name = "stat_value")
    val value: Int
)

data class StatWithValue(
    @Embedded
    val stat: Stat
)
