package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "base_classes",
    foreignKeys = [
        ForeignKey(entity = Stats::class, parentColumns = ["id"], childColumns = ["class_stats_id"])
    ]
)
data class BaseClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "class_name")
    val name: String,
    @ColumnInfo(name = "class_stats_id")
    val statsId: Int
)
