package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Events

@Dao
abstract class EventsDao : BaseDao<Events>() {

}