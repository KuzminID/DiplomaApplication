package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "login")
    val login : String,
    @ColumnInfo(name = "email")
    val email : String,
    @ColumnInfo(name="password")
    val password : String
)