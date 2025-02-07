package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "character_equipment",
    foreignKeys = [
        ForeignKey(entity = Characters::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE)])
data class CharacterEquipment(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "character_id")
    val characterId: Int,

    @ColumnInfo(name = "item_id")
    val itemId: Int,

    @ColumnInfo(name = "slot")
    val slot: String
)