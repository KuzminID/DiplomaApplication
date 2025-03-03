package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.EventsHistory

@Dao
abstract class HistoryDao : BaseDao<EventsHistory>() {
}