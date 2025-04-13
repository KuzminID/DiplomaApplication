package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stat")
data class Stat(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "is_primary")
    val isPrimary: Boolean,
    @ColumnInfo(name = "stat_name")
    val name: String,
    @ColumnInfo(name = "stat_description")
    val description: String
)
