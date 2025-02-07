package com.example.diplomaapplication.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "skill_bonuses",
    foreignKeys = [
        ForeignKey(entity = Skill::class,
            parentColumns = ["id"],
            childColumns = ["skill_id"],
            onDelete = ForeignKey.CASCADE)])
data class SkillBonus(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "skill_id")
    val skillId: Int,

    @ColumnInfo(name = "level_required")
    val levelRequired: Int,

    @ColumnInfo(name = "stat_type")
    val statType: String,

    @ColumnInfo(name = "bonus_value")
    val bonusValue: Int
)
