package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "character_skills",
    foreignKeys = [
        ForeignKey(entity = Characters::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Skill::class,
            parentColumns = ["id"],
            childColumns = ["skill_id"],
            onDelete = ForeignKey.CASCADE)])
data class CharacterSkill(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "character_id")
    val characterId: Int,

    @ColumnInfo(name = "skill_id")
    val skillId: Int,

    @ColumnInfo(name = "level")
    val level: Int?,

    @ColumnInfo(name = "experience")
    val experience: Int?,

    @ColumnInfo(name = "required_exp")
    val requiredExp: Int?
)
