package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.EventsHistory

@Dao
abstract class HistoryDao : BaseDao<EventsHistory>() {
}