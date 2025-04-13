package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.diplomaapplication.data.local.entities.Events

@Dao
interface EventsDao : BaseDao<Events> {
    @Query("SELECT * FROM events_table")
    fun getAllEvents(): List<Events>
}