package com.example.diplomaapplication.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "base_class_stats",
    foreignKeys = [
        ForeignKey(
            entity = Stats::class,
            parentColumns = ["id"],
            childColumns = ["base_class_stats_id"]
        ),
        ForeignKey(
            entity = BaseClasses::class,
            parentColumns = ["id"],
            childColumns = ["base_class_id"]
        )
    ]
)
data class BaseClassStats(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "base_class_stats_id")
    val statsId: Long,
    @ColumnInfo(name = "base_class_id")
    val baseClassId: Long
)

data class BaseClassWithStats(
    @Embedded val baseClass: BaseClasses,
    @Relation(
        parentColumn = "id",
        entityColumn = "base_class_id",
        entity = BaseClassStats::class,
        projection = ["base_class_stats_id"]
    ) val statsIdList: List<Long>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = Stats::class,
        associateBy = Junction(BaseClassStats::class)
    ) val stats: List<Stats>
)
