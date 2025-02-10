package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "skills_value",
    foreignKeys = [
        ForeignKey(
            entity = Skill::class,
            parentColumns = ["id"],
            childColumns = ["skill_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class CharacterSkillsValue (
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "skill_id")
    val skillID : Int,
    @ColumnInfo(name = "character_id")
    val characterID : Int,
    @ColumnInfo(name = "skill_level")
    val skillLevel : Int,
    @ColumnInfo(name = "skill_experience")
    val skillExp : Int
    )