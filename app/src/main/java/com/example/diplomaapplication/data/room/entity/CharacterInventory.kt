package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "character_inventory")
data class CharacterInventory(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "character_id")
    val characterID : Int,
    @ColumnInfo(name = "inventory_capacity")
    val capacity : Int
)

data class CharacterWithInventory(
    @Embedded
    val character : Character,
    @Relation(
        parentColumn = "",
        entityColumn = "" //TODO add parent and entity columns
    )
    val items : List<ItemWithRarityAndType>
)

