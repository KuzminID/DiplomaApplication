package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_inventory",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        )
    ]
)
data class CharacterInventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "capacity")
    val capacity: Int = 10,
    @ColumnInfo(name = "character_id")
    val characterId: Int
)

@Entity(
    tableName = "inventory_items",
    foreignKeys = [
        ForeignKey(
            entity = CharacterInventory::class,
            parentColumns = ["id"],
            childColumns = ["inventory_id"]
        ),
        ForeignKey(entity = Item::class, parentColumns = ["id"], childColumns = ["item_id"])
    ]
)
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_id")
    val itemId: Int,
    @ColumnInfo(name = "quantity")
    val quantity: Int,
    @ColumnInfo(name = "inventory_id")
    val inventoryId: Int
)