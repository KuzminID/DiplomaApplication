package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "SkillLevelBonuses",
    foreignKeys = [
        ForeignKey(
            entity = Skill::class,
            parentColumns = ["id"],
            childColumns = ["skill_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Stat::class,
            parentColumns = ["id"],
            childColumns = ["stat_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class SkillBonuses(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "skill_id")
    val skillID : Int,
    @ColumnInfo(name = "required_level")
    val requiredLvl : Int,
    @ColumnInfo(name = "stat_id")
    val statID : Int,
    @ColumnInfo(name = "bonus_stat_value")
    val statValue : Int
)
