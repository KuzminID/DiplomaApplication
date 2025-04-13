package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity( //TODO add foreign key
    tableName = "character",
    foreignKeys = [
        ForeignKey(
            entity = BaseClasses::class,
            parentColumns = ["id"],
            childColumns = ["character_base_class_id"]
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        )
    ]
)
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "character_name")
    val name: String,
    @ColumnInfo(name = "character_level")
    val level: Int = 1,
    @ColumnInfo(name = "character_experience")
    val experience: Int = 0,
    @ColumnInfo(name = "character_base_class_id")
    val baseClassId: Long,
    @ColumnInfo(name = "user_id")
    val userId: Long
)

data class FulLCharacterData(
    val id: Int
)
