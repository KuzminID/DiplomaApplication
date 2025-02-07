package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "enemy_loot",
    foreignKeys = [
        ForeignKey(entity = Enemy::class,
            parentColumns = ["id"],
            childColumns = ["enemy_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["location_id"],
            onDelete = ForeignKey.CASCADE)])
data class EnemyLoot(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "enemy_id")
    val enemyId: Int,

    @ColumnInfo(name = "item_id")
    val itemId: Int,

    @ColumnInfo(name = "location_id")
    val locationId: Int?,

    @ColumnInfo(name = "probability")
    val probability: Float
)