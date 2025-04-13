package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// Add to data/local/entities/Item.kt
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_description")
    val description: String,
    @ColumnInfo(name = "item_type")
    val type: String, // "weapon", "armor", "consumable", etc.
    @ColumnInfo(name = "item_value")
    val value: Int,
    @ColumnInfo(name = "item_rarity")
    val rarity: Double // 0.0-1.0 for drop chance
)

// Add to data/local/entities/Inventory.kt
@Entity(
    tableName = "inventory",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"]
        )
    ]
)
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "character_id")
    val characterId: Long,
    @ColumnInfo(name = "item_id")
    val itemId: Long,
    @ColumnInfo(name = "quantity")
    val quantity: Int
)

// Add to data/local/entities/EnemyLoot.kt
@Entity(
    tableName = "enemy_loot",
    foreignKeys = [
        ForeignKey(
            entity = Enemies::class,
            parentColumns = ["id"],
            childColumns = ["enemy_id"]
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"]
        )
    ]
)
data class EnemyLoot(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "enemy_id")
    val enemyId: Long,
    @ColumnInfo(name = "item_id")
    val itemId: Long,
    @ColumnInfo(name = "drop_chance")
    val dropChance: Double
)