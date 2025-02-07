package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val userId : Int? = null,
    @ColumnInfo(name = "username")
    val username : String,
    @ColumnInfo(name = "email")
    val email:String,
    @ColumnInfo(name="password")
    val password : String,
    @ColumnInfo(name="created_at")
    val createdAt : Long,
    @ColumnInfo(name="last_login")
    val lastLogin : Long
)
