package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_description")
    val description: String,
    @ColumnInfo(name = "item_type")
    val type: Int,
    @ColumnInfo(name = "item_rarity")
    val rarity: Int,
    @ColumnInfo(name = "item_stats_id")
    val statsId: Int
)