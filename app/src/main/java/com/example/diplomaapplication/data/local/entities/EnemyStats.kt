package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "enemies_stats",
    foreignKeys = [
        ForeignKey(
            entity = Stats::class,
            parentColumns = ["id"],
            childColumns = ["enemy_stats_id"]
        ),
        ForeignKey(
            entity = Enemies::class,
            parentColumns = ["id"],
            childColumns = ["enemy_id"]
        )
    ]
)
data class EnemyStats(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "enemy_id")
    val enemyId: Long,
    @ColumnInfo(name = "enemy_stats_id")
    val statsId: Long
)
