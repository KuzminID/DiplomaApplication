package com.example.diplomaapplication.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "drop_table_item",
    foreignKeys = [
        ForeignKey(
            entity = Enemies::class,
            parentColumns = ["id"],
            childColumns = ["enemy_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class DropTableItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    @ColumnInfo(name = "enemy_id")
    val enemyID : Int,
    @ColumnInfo(name = "item_id")
    val itemID : Int,
    @ColumnInfo(name = "drop_rate")
    val dropRate : Double
)

data class EnemyWithDropTable(
    @Embedded val enemy : Enemies,
    @Relation(
        parentColumn = "id",
        entityColumn = "enemy_id",
        entity = DropTableItem::class
    )
    val dropTable : List<DropTableItem>
)


