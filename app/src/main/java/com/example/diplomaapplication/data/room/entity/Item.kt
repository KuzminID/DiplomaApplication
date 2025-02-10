package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "items",
    foreignKeys = [
        ForeignKey(
            entity = ItemTypes::class,
            parentColumns = ["id"],
            childColumns = ["item_type_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ItemRarity::class,
            parentColumns = ["id"],
            childColumns = ["item_rarity_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "item_name")
    val name : String,
    @ColumnInfo(name = "item_type_id")
    val type : Int,
    @ColumnInfo(name = "item_rarity_id")
    val rarity: Int
)

data class ItemWithRarityAndType(
    @Embedded
    val item : Item,
    @Embedded
    val itemType : ItemTypes,
    @Embedded
    val itemRarity: ItemRarity
)
