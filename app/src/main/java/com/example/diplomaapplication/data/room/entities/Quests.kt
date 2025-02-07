package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.diplomaapplication.data.room.utils.JsonConverter

@Entity(tableName = "quests")
data class Quest(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "reward")
    @TypeConverters(JsonConverter::class)
    val reward: Map<String, Any>?
)