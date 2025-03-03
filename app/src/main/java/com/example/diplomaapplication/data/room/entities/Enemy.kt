package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "enemies",
    foreignKeys = [
        ForeignKey(
            entity = Stats::class,
            parentColumns = ["id"],
            childColumns = ["enemy_stats_id"]
        ),
        ForeignKey(
            entity = EnemyDrop::class,
            parentColumns = ["id"],
            childColumns = ["drop_table_id"]
        )
    ]
)
data class Enemy(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "enemy_name")
    val name: String,
    @ColumnInfo(name = "enemy_description")
    val description: String,
    @ColumnInfo(name = "enemy_stats_id")
    val statsId: Int,
    @ColumnInfo(name = "drop_table_id") // Связь с таблицей дропа
    val dropTableId: Int
)

// Таблица дропа врагов
@Entity(
    tableName = "enemy_drops",
    foreignKeys = [
        ForeignKey(entity = Item::class, parentColumns = ["id"], childColumns = ["item_id"])
    ]
)
data class EnemyDrop(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_id")
    val itemId: Int,
    @ColumnInfo(name = "chance")
    val chance: Double
)