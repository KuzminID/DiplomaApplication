package com.example.diplomaapplication.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "event_history",
    foreignKeys = [
        ForeignKey(
            entity = Events::class,
            parentColumns = ["id"],
            childColumns = ["event_type_id"]
        ),
        ForeignKey(entity = Enemy::class, parentColumns = ["id"], childColumns = ["enemy_id"])
    ]
)
data class EventsHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "event_type_id")
    val eventTypeId: Int,
    @ColumnInfo(name = "enemy_id")
    val enemyId: Int? = null,
    @ColumnInfo(name = "character_winner")
    val isCharacterWinner: Boolean? = null
)

@Entity(
    tableName = "event_history_dropped_items",
    foreignKeys = [
        ForeignKey(
            entity = EventsHistory::class,
            parentColumns = ["id"],
            childColumns = ["history_id"]
        )
    ]
)
data class EventHistoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "dropped_item_id")
    val itemId: Int,
    @ColumnInfo(name = "dropped_item_quantity")
    val quantity: Int = 0,
    @ColumnInfo(name = "history_id")
    val historyId: Int
)

data class EventHistoryItemWithDroppedItems(
    @Embedded
    val eventHistoryItem: EventHistoryItem,
    @Embedded
    val item: Item
)

data class EventHistoryData(
    @Embedded
    val eventHistory: EventsHistory,
    @Relation(
        parentColumn = "history_id",
        entityColumn = "id"
    )
    val historyItemWithDropped: List<EventHistoryItemWithDroppedItems>,
    @Embedded
    val enemy: Enemy
)
