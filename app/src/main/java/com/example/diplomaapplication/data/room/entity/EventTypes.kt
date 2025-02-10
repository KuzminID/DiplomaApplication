package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_types")
data class EventTypes(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    @ColumnInfo(name = "event_type_name")
    val typeName : String
)
