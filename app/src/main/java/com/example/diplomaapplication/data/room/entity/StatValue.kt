package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "stat_value",
    foreignKeys = [
        ForeignKey(entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE)
    ])
data class StatValue(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "stat_id")
    val statID : Int,
    @ColumnInfo(name = "stat_value")
    val value : Int,
    @ColumnInfo(name = "character_id")
    val characterID : Int
)

data class CharacterWithStats(
    @Embedded val character : Character,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val stats : List<StatValue>
)
//TODO enemyID and characterID must be different
data class EnemyWithStats(
    @Embedded val enemy : Enemies,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val stats : List<StatValue>
)

data class ItemWithStats(
    @Embedded
    val item : Item,
    @Relation(
        parentColumn = "id",
        entityColumn = "stats_id"
    )
    val stats : List<StatValue>
)



