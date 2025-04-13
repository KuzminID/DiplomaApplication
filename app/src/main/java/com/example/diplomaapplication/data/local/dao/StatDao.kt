package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.local.entities.Stat
import com.example.diplomaapplication.data.local.entities.Stats

@Dao
interface StatDao : BaseDao<Stat>

@Dao
interface StatsDao : BaseDao<Stats> {
}