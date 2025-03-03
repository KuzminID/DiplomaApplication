package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Stats

@Dao
abstract class StatsDao : BaseDao<Stats>() {
}