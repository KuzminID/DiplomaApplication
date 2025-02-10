package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "inventory_item",
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CharacterInventory::class,
            parentColumns = ["id"],
            childColumns = ["inventory_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "item_id")
    val itemID : Int,
    @ColumnInfo(name = "quantity")
    val quantity : Int,
    @ColumnInfo(name = "inventory_id")
    val inventoryID : Int
)
