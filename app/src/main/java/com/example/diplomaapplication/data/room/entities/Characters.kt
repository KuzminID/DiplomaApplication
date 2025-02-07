package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "characters",
    foreignKeys = [
        ForeignKey(entity = Users::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE)])
data class Characters(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "user_id")
    val userId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "class_id")
    val classId: Int?,

    @ColumnInfo(name = "level")
    val level: Int,

    @ColumnInfo(name = "experience")
    val experience: Int,

    @ColumnInfo(name = "required_experience")
    val requiredExperience: Int,

    @ColumnInfo(name = "current_location_id")
    val currentLocationId: Int,

    @ColumnInfo(name = "created_at")
    val createdAt: Long
)
