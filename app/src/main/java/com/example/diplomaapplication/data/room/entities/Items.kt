package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.diplomaapplication.data.room.utils.JsonConverter

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "item_type")
    val itemType: String,

    @ColumnInfo(name = "item_slot")
    val itemSlot: String,

    @ColumnInfo(name = "base_stats")
    @TypeConverters(JsonConverter::class)
    val baseStats: Map<String, Any>?
)
