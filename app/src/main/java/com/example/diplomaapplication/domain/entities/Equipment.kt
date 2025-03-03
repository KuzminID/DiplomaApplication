package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "equipment_slots")
data class EquipmentSlot(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "slot_name")
    val name: String
)

@Entity(
    tableName = "equipment",
    foreignKeys = [
        ForeignKey(
            entity = EquipmentSlot::class,
            parentColumns = ["id"],
            childColumns = ["slot_id"]
        ),
        ForeignKey(entity = Item::class, parentColumns = ["id"], childColumns = ["item_id"])
    ]
)
data class Equipment(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "slot_id")
    val slotId: Int,
    @ColumnInfo(name = "item_id")
    val itemId: Int?
)

@Entity(
    tableName = "equipped_items",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        ),
        ForeignKey(
            entity = Equipment::class,
            parentColumns = ["id"],
            childColumns = ["equipment_id"]
        )
    ]
)
data class EquippedItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "equipment_id")
    val equipmentId: Int
)