package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_skills",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"]
        ),
        ForeignKey(entity = Skill::class, parentColumns = ["id"], childColumns = ["skill_id"])
    ]
)
data class CharacterSkill(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "skill_id")
    val skillId: Int,
    @ColumnInfo(name = "level")
    val level: Int,
    @ColumnInfo(name = "character_id")
    val characterId: Int
)