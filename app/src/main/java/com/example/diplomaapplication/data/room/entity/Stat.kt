package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stat")
data class Stat(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "description")
    val description : String
)
