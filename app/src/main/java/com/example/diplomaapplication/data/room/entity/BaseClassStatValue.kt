package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "base_class_stat_value",
    foreignKeys = [
        ForeignKey(entity = BaseClasses::class,
            parentColumns = ["id"],
            childColumns = ["base_class_id"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Stat::class,
            parentColumns = ["id"],
            childColumns = ["stat_id"],
            onDelete = ForeignKey.CASCADE)
    ]
)
data class BaseClassStatValue(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "stat_id")
    val statID : Int,
    @ColumnInfo(name = "stat_value")
    val value : Int,
    @ColumnInfo(name = "base_class_id")
    val baseClassID : Int
)

data class CharacterWithBaseStats(
    @Embedded val character : Character,
    @Relation(
        parentColumn = "base_class_id",
        entity = BaseClassStatValue::class,
        entityColumn = "base_class_id"
    )
    val baseClassStats : List<BaseClassStatValue>
)